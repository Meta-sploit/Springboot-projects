package com.springboot.controller;

import com.springboot.entity.Department;
import com.springboot.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DepartmentController {
    @Autowired
    DepartmentService departmentService;
    @PostMapping("/saveDepartment")
    public Department saveDepartment(@RequestBody Department department){
        return departmentService.save(department);
    }
    @GetMapping("/Department")
    public List<Department> getAllDepartment(){
        return departmentService.getAllDepartment();
    }
    @GetMapping("/Department/{id}")
    public Department fetchDepartmentById(@PathVariable("id") Long DepartmentId){
        return departmentService.fetchDepartmentById(DepartmentId);
    }
    @DeleteMapping("/Department/{id}")
    public String deleteDepartmentById(@PathVariable("id") Long DepartmentId){
        return departmentService.deleteDepartmentById(DepartmentId);
    }
    @PutMapping("/Department/{id}")
    public Department updateDepartmentById(@PathVariable("id") Long DepartmentId, @RequestBody Department department){
        return departmentService.updateDepartmentById(DepartmentId,department);
    }
}
