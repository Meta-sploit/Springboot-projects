package com.springboot.service;

import com.springboot.entity.Department;

import java.util.List;

public interface DepartmentService {
    Department save(Department department);

    List<Department> getAllDepartment();
}
