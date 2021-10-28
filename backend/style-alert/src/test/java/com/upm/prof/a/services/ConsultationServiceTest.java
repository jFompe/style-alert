package com.upm.prof.a.services;

import com.upm.prof.a.controller.ConsultationController;
import com.upm.prof.a.persistence.Consultation;
import com.upm.prof.a.persistence.User;
import com.upm.prof.a.repository.ConsultationRepo;
import com.upm.prof.a.repository.UserRepo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

@RunWith(MockitoJUnitRunner.class)
public class ConsultationServiceTest {

    @InjectMocks
    ConsultationService consultationService;

    @Mock
    UserRepo userRepo;

    @Mock
    ConsultationRepo consultationRepo;

    @Test
    public void getConsultations() throws Exception {
        //Creacion de los datos para las pruebas
        Consultation consultation = new Consultation();
        consultation.setName("prueba"); consultation.setUrl("www.prueba.com");consultation.setRegistrationTime(new Date());
        List<Consultation> consultations = new ArrayList<>();
        consultations.add(consultation);
        User usuario = new User();
        usuario.setId(1L);

        //Hacer los setters de las relaciones
        consultation.setUser(usuario);
        usuario.setConsultations(consultations);

        //Mockear los repos
        Mockito.when(userRepo.findById(1L)).thenReturn(Optional.of(usuario));
        Mockito.when(consultationRepo.findByUserId(1L)).thenReturn(consultations);

        List<Consultation> result = consultationService.getConsultation(1L);

        assertEquals(consultations.size(), result.size());
        assertEquals(consultations.get(0).getName(), result.get(0).getName());
        assertEquals(consultations.get(0).getUrl(), result.get(0).getUrl());

    }

}
