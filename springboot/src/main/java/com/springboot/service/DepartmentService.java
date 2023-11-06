package com.springboot.service;

import com.springboot.entity.Department;

import java.util.List;

public interface DepartmentService {
    public Department save(Department department);

    public List<Department> getAllDepartment();

    public Department fetchDepartmentById(Long departmentId);

    public String deleteDepartmentById(Long departmentId);

    public Department updateDepartmentById(Long departmentId, Department department);
}
