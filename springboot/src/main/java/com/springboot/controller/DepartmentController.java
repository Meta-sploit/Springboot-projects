package com.springboot.controller;

import com.springboot.entity.Department;
import com.springboot.service.DepartmentService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import javax.validation.Valid;

@RestController
public class DepartmentController {
    @Autowired
    DepartmentService departmentService;

    private final Logger logger= LoggerFactory.getLogger(DepartmentController.class);

    @PostMapping("/saveDepartment")
    public Department saveDepartment(@Valid @RequestBody Department department) {
        logger.info("Inside the 'saveDepartment' method of controller DepartmentController");
        return departmentService.save(department);
    }

    @GetMapping("/Department")
    public List<Department> getAllDepartment() {
         logger.info("Inside the 'getAllDepartment' method of controller DepartmentController");
        return departmentService.getAllDepartment();
    }

    @GetMapping("/Department/{id}")
    public Department fetchDepartmentById(@PathVariable("id") Long DepartmentId) {
        return departmentService.fetchDepartmentById(DepartmentId);
    }

    @DeleteMapping("/Department/{id}")
    public String deleteDepartmentById(@PathVariable("id") Long DepartmentId) {
        return departmentService.deleteDepartmentById(DepartmentId);
    }

    @PutMapping("/Department/{id}")
    public Department updateDepartmentById(@PathVariable("id") Long DepartmentId, @RequestBody Department department) {
        return departmentService.updateDepartmentById(DepartmentId, department);
    }

    @GetMapping("/Department/name/{name}")
    public Department getDepartmentByName(@PathVariable("name") String DepartmentName) {
        return departmentService.getDepartmentByName(DepartmentName);
    }
}
