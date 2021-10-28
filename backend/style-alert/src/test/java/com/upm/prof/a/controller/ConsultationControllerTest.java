package com.upm.prof.a.controller;

import com.upm.prof.a.persistence.Consultation;
import com.upm.prof.a.persistence.User;
import com.upm.prof.a.repository.ConsultationRepo;
import com.upm.prof.a.repository.UserRepo;
import com.upm.prof.a.services.ConsultationService;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.*;

import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(ConsultationController.class)
public class ConsultationControllerTest {
    @Autowired
    MockMvc mockMvc;

    @InjectMocks
    ConsultationController consultationController;

    @Mock
    ConsultationService consultationService;

    @Mock
    UserRepo userRepo;

    @Mock
    ConsultationRepo consultationRepo;

    @Test
    public void getConsultations() throws Exception {
        List<Consultation> consultations = new ArrayList<>();
        User usuario = new User();
        Consultation consultation = new Consultation();
        consultation.setName("prueba"); consultation.setUrl("www.prueba.com");consultation.setRegistrationTime(new Date());
        consultations.add(consultation);

        Mockito.when(userRepo.findById(1L)).thenReturn(Optional.of(usuario));
        Mockito.when(consultationRepo.findByUserId(1L)).thenReturn(consultations);
        Mockito.when(consultationService.getConsultation(1L)).thenReturn(consultations);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/consultation/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect((ResultMatcher) jsonPath("$[2].name", is("prueba")));
    }

}
