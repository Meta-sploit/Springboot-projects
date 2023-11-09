package com.springboot.service;

import com.springboot.ExceptionHandling.DepartmentNotfoundExpetion;
import com.springboot.entity.Department;
import com.springboot.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentServiceImp implements DepartmentService {

    @Autowired
    DepartmentRepository departmentRepository;

    @Override
    public Department save(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> getAllDepartment() {
        List<Department> list = departmentRepository.findAll();
        return list;
    }

    @Override
    public Department fetchDepartmentById(Long departmentId) throws DepartmentNotfoundExpetion {
        Optional<Department> obj=  departmentRepository.findById(departmentId);
        if(!obj.isPresent()){
            throw new DepartmentNotfoundExpetion("Depatment Not Found");
        }
        return obj.get();
    }

    @Override
    public String deleteDepartmentById(Long departmentId) {
        departmentRepository.deleteById(departmentId);
        return "department deleted with id " + departmentId;
    }

    @Override
    public Department updateDepartmentById(Long departmentId, Department department) {
        Department deptData = departmentRepository.findById(departmentId).get();
        if (Objects.nonNull(department.getDepartmentName()) && !"".equalsIgnoreCase(department.getDepartmentName())) {
            deptData.setDepartmentName(department.getDepartmentName());
        }
        if (Objects.nonNull(department.getDepartmentAddress())
                && !"".equalsIgnoreCase(department.getDepartmentAddress())) {
            deptData.setDepartmentName(department.getDepartmentAddress());
        }
        if (Objects.nonNull(department.getDepartmentCode()) && !"".equalsIgnoreCase(department.getDepartmentCode())) {
            deptData.setDepartmentName(department.getDepartmentCode());
        }
        return departmentRepository.save(deptData);
    }

    @Override
    public Department getDepartmentByName(String departmentName) {
        return departmentRepository.findByDepartmentNameIgnoreCase(departmentName);
        /***
         * string IgnoreCase appended to function so that
         * irrespective of upper or lower case our code will work
         ***/
    }
}