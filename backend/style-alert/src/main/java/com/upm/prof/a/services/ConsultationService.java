package com.upm.prof.a.services;

import java.util.List;

import com.upm.prof.a.persistence.Consultation;
import com.upm.prof.a.persistence.User;
import com.upm.prof.a.repository.ConsultationRepo;
import com.upm.prof.a.repository.UserRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ConsultationService {

    @Autowired
    private ConsultationRepo consultationRepo;

    @Autowired
    private UserRepo userRepo;

    public ResponseEntity<List<Consultation>> getConsultation(Long id) throws NotFoundException {
        User currentUser = userRepo.findById(id).orElseThrow(() -> 
            new NotFoundException());
		List<Consultation> consultations = consultationRepo.findByUser(currentUser);
                 
		return new ResponseEntity<>(consultations, HttpStatus.OK);
	}
    
}
