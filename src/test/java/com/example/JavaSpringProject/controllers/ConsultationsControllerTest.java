package com.example.JavaSpringProject.controllers;

import com.example.JavaSpringProject.exceptions.ResourceNotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ConsultationsControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void edit() throws Exception {
        mockMvc.perform(get("/Consultations/edit/{id}", "17"))
                .andExpect(status().isNotFound())
                .andExpect(view().name("Exceptions/404"));
    }
}