package com.upm.prof.a.controller;

import com.upm.prof.a.persistence.Consultation;
import com.upm.prof.a.persistence.User;
import com.upm.prof.a.services.ConsultationService;
import com.upm.prof.a.services.LogService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(LogController.class)
public class LogControllerTest {
    @Autowired
    MockMvc mockMvc;

    @InjectMocks
    LogController logController;

    @MockBean
    LogService logService;

    @Test
    public void getId() throws Exception {
        long resultado = 0;
        User usuario = new User();
        usuario.setUsername("alex");
        usuario.setId(12345);
//        usuario.setPassword("1234");
//        usuario.setEmail("prueba@prueba.com");

        Mockito.when(logService.getIdActualUser("alex")).thenReturn(resultado);


        mockMvc.perform(MockMvcRequestBuilders.get("/api/log/login/{user_name}","alex"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$user_id").value(usuario.getId()));
    }
}
