package com.upm.prof.a.controller;

import com.upm.prof.a.persistence.Consultation;
import com.upm.prof.a.persistence.User;
import com.upm.prof.a.services.ConsultationService;
import com.upm.prof.a.services.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/log")
public class LogController {

    @Autowired
    private LogService logService;

    @GetMapping(path="/login?{user_name}&{user_password}", produces = "application/json")
    public boolean checkLogIn(@PathVariable(name = "user_name") String userName, @PathVariable(name = "user_password") String password) throws ChangeSetPersister.NotFoundException {
        return logService.correctLogin(userName, password);
    }

    @GetMapping(path="/login/{user_name}", produces = "application/json")
    public long getUserId(@PathVariable(name = "user_name") String userName) throws ChangeSetPersister.NotFoundException {
        return logService.getIdActualUser(userName);
    }

    @PostMapping(path = "/singUp?{user_id}&{user_password}&{user_email}&{user_name}", consumes = "application/json", produces = "application/json")
    public boolean postConsultation(@PathVariable(name = "user_id") Long userId, @PathVariable(name = "user_name") String userName, @PathVariable(name = "user_password") String password, @PathVariable(name = "user_email") String email) throws ChangeSetPersister.NotFoundException {
       return logService.addUser(userId, userName, password, email);
    }



}