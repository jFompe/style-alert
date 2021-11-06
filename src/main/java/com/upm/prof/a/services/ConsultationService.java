package com.upm.prof.a.services;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import com.google.gson.Gson;

import com.upm.prof.a.persistence.Consultation;
import com.upm.prof.a.persistence.User;
import com.upm.prof.a.repository.ConsultationRepo;
import com.upm.prof.a.repository.UserRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;



@Service
public class ConsultationService {

    @Autowired
    private ConsultationRepo consultationRepo;

    @Autowired
    private UserRepo userRepo;

    private static final Gson gson = new Gson();

    public List<Consultation> getConsultation(Long id) throws NotFoundException {
        User currentUser = userRepo.findById(id).orElseThrow(() -> 
            new NotFoundException());
		List<Consultation> consultations = consultationRepo.findByUserId(id);
		for (Consultation consultation: consultations){
            consultation.setUpdateTime(this.getLastUpdate(consultation));
        }
		return consultations;
	}

	public Consultation postConsultation (Long id, Consultation consultation) throws NotFoundException {
        User currentUser = userRepo.findById(id).orElseThrow(() ->
                new NotFoundException());
        Date date = new Date();

        consultation.setUser(currentUser);
        consultation.setRegistrationTime(date);
        consultation.setUpdateTime(this.getLastUpdate(consultation));
        consultationRepo.save(consultation);
        return consultation;
    }

    private Date getLastUpdate (Consultation consultation){
        String url = consultation.getUrl();
        String llamadaAPI = " http://archive.org/wayback/available?"+ url;
        RestTemplate llamada = new RestTemplate();
        ResponseEntity responseEntity = llamada.getForEntity(llamadaAPI,ResponseEntity.class);
        String resultado = gson.toJson(responseEntity.getBody());

        return null;
    }
}
