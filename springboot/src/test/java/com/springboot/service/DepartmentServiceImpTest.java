package com.springboot.service;

import com.springboot.entity.Department;
import com.springboot.repository.DepartmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ActiveProfiles("test")
class DepartmentServiceImpTest {
    @Autowired
    DepartmentService departmentService;

    @MockBean
    DepartmentRepository departmentRepository;

    @BeforeEach
    void setUp() {
        Department department = Department.builder()
                .departmentCode("IT-06")
                .departmentAddress("Hyderabad")
                .departmentName("IT")
                .departmentId(1L)
                .build();

        Mockito.when(departmentRepository.findByDepartmentNameIgnoreCase("IT")).thenReturn(department);
    }

    @Test
    @DisplayName("Validation for the department")
    public void whenValidDepartment_thenDepartmentShouldFound() {
        String department = "IT";
        Department foundDepartment = departmentService.getDepartmentByName(department);
        assertEquals(department, foundDepartment.getDepartmentName());
    }
}