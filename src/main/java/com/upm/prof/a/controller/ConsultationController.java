package com.upm.prof.a.controller;

import lombok.Data;

import java.util.List;

import com.upm.prof.a.persistence.Consultation;
import com.upm.prof.a.services.ConsultationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/consultation")
public class ConsultationController {

    @Autowired
    private ConsultationService consultationService;

    @GetMapping(path="/{user_id}", produces = "application/json")
	public List<Consultation> getConsultations(@PathVariable(name = "user_id") Long userId) throws NotFoundException {
		return consultationService.getConsultation(userId);
	}

	@PostMapping(path = "/{user_id}", consumes = "application/json", produces = "application/json")
    public Consultation postConsultation(@PathVariable(name = "user_id") Long userId,
            @Validated @RequestBody Consultation consultation) throws NotFoundException {
        return consultationService.postConsultation(userId, consultation);
    }



}
