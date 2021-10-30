package com.upm.prof.a.controller;

import lombok.Data;

import java.util.List;

import com.upm.prof.a.persistence.Consultation;
import com.upm.prof.a.services.ConsultationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/api/consultation")
public class ConsultationController {

    @Autowired
    private ConsultationService consultationService;

    @GetMapping(path="/{user_id}", produces = "application/json")
	public List<Consultation> getConsultations(@PathVariable(name = "user_id") Long userId) throws NotFoundException {
		return consultationService.getConsultation(userId);
	}

}
