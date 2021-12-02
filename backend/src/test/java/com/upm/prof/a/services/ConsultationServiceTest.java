package com.upm.prof.a.services;

import com.upm.prof.a.controller.ConsultationController;
import com.upm.prof.a.persistence.Consultation;
import com.upm.prof.a.persistence.User;
import com.upm.prof.a.repository.ConsultationRepo;
import com.upm.prof.a.repository.UserRepo;
import javassist.NotFoundException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.data.crossstore.ChangeSetPersister;


import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(MockitoJUnitRunner.class)
public class ConsultationServiceTest {

    @InjectMocks
    ConsultationService consultationService;

    @Mock
    UserRepo userRepo;

    @Mock
    ConsultationRepo consultationRepo;


    @Test
    public void whenUserExists_getConsultations_ReturnsSuccess() throws Exception {
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

   // @Test
   // public void whenUserNotExist_getConsultations_ThrowsException() throws Exception {
    //    Mockito.when(userRepo.findById(1L)).thenThrow(ClassNotFoundException.class);
       // consultationService.getConsultation(1l);

     //   assertThrows(NotFoundException, consultationService.getConsultation(1l));

    //}

    @Test
    public void whenUserExists_postConsultations_ReturnSuccess() throws ChangeSetPersister.NotFoundException, ParseException {
        User usuario = new User();
        usuario.setId(1L);
        usuario.setEmail("prueba@gmail.com");

        Consultation expected = new Consultation();
        expected.setUrl("www.prueba.com");
        expected.setName("prueba");

        //Mockear los repos
        Mockito.when(userRepo.findById(1L)).thenReturn(Optional.of(usuario));

        Consultation result = consultationService.postConsultation(1L, expected);
        assertEquals(usuario.getEmail(), result.getUser().getEmail());
        assertEquals(usuario.getId(), result.getUser().getId());
        assertEquals(expected.getUrl(), result.getUrl());
        assertEquals(expected.getName(), result.getName());
    }
}
