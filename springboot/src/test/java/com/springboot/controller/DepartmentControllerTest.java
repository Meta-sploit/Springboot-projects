package com.springboot.controller;

import com.springboot.entity.Department;
import com.springboot.service.DepartmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest
class DepartmentControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    DepartmentService departmentService;


    private Department department;
    @BeforeEach
    void setUp() {
        department= Department.builder()
                .departmentAddress("Delhi")
                .departmentId(1L)
                .departmentName("ELECTRIC")
                .departmentCode("EE")
                .build();
    }

    @Test
    void saveDepartment() throws Exception {
       Department inputDepartment = Department.builder()
               .departmentAddress("Delhi")
               .departmentName("ELECTRIC")
               .departmentCode("EE")
               .build();

        Mockito.when(departmentService.save(inputDepartment)).thenReturn(department);

        mockMvc.perform(MockMvcRequestBuilders.post("/saveDepartment").contentType(MediaType.APPLICATION_JSON)
                .content("{\"departmentName\":\"CEo\",\"departmentAddress\":\"321\",\"departmentCode\":\"XYZ\"}"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
    @Test
    void fetchDepartmentById() throws Exception {
        Mockito.when(departmentService.fetchDepartmentById(1L)).thenReturn(department);

        mockMvc.perform(MockMvcRequestBuilders.get("/Department/1")
                        .contentType(MediaType.APPLICATION_JSON))
                        .andExpect(MockMvcResultMatchers.status().isOk())
                        .andExpect(MockMvcResultMatchers.jsonPath("$.departmentName")
                        .value(department.getDepartmentName()));
    }


}