package com.upm.prof.a.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.google.gson.Gson;

import com.upm.prof.a.pojo.Archived_snapshots;
import com.upm.prof.a.persistence.Consultation;
import com.upm.prof.a.persistence.User;
import com.upm.prof.a.pojo.Busqueda;
import com.upm.prof.a.repository.ConsultationRepo;
import com.upm.prof.a.repository.UserRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;



@Service
public class ConsultationService {

    @Autowired
    private ConsultationRepo consultationRepo;

    @Autowired
    private UserRepo userRepo;


    public List<Consultation> getConsultation(Long id) throws NotFoundException, ParseException {
        User currentUser = userRepo.findById(id).orElseThrow(() -> 
            new NotFoundException());
		List<Consultation> consultations = consultationRepo.findByUserId(id);
		for (Consultation consultation: consultations){
		    //System.out.println(this.getLastUpdate(consultation));
            if(this.getLastUpdate(consultation)==null){
                continue;
            }
            Date updated = new SimpleDateFormat("YYYYMMDDhhmmss").parse(this.getLastUpdate(consultation));
            consultation.setUpdateTime(updated);
            consultationRepo.save(consultation);
        }
		return consultations;
	}

	public Consultation postConsultation (Long id, Consultation consultation) throws NotFoundException, ParseException {
        User currentUser = userRepo.findById(id).orElseThrow(() ->
                new NotFoundException());
        Date date = new Date();

        consultation.setUser(currentUser);
        consultation.setRegistrationTime(date);
        Date updated;
        if(this.getLastUpdate(consultation)== null){
            updated = new Date(System.currentTimeMillis());
        } else{
            updated = new SimpleDateFormat("YYYYMMDDhhmmss").parse(this.getLastUpdate(consultation));
        }
        consultation.setUpdateTime(updated);
        consultationRepo.save(consultation);
        return consultation;
    }

    private String getLastUpdate (Consultation consultation){
        String url = consultation.getUrl();
        String llamadaAPI = "http://archive.org/wayback/available?url="+ url;
        RestTemplate llamada = new RestTemplate();
        ResponseEntity<Busqueda> responseEntity = llamada.getForEntity(llamadaAPI, Busqueda.class);
        if(responseEntity.getBody().getArchived_snapshots() ==null){
            return null;
        }
        return responseEntity.getBody().getArchived_snapshots().getClosest().getTimestamp();
    }
}
