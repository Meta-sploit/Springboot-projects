package com.learning.JPATutorial.repository;

import com.learning.JPATutorial.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    StudentRepository studentRepository;
    @Test
    public void generateTestForStudentCreation(){
        Student student=Student.builder().emailId("abhi@gmail.com").firstName("raghu")
                .secondName("chauhan")
                .gaurdianEmailId("nikhil@gmail.com")
                .gaurdianName("Nikhil")
                .gaurdianMobile("9999999999").build();
        studentRepository.save(student);
    }
    
    @Test
    public void getAllStudent(){
        List<Student> studentList= studentRepository.findAll();
        System.out.println("studentList = " + studentList);
    }

}