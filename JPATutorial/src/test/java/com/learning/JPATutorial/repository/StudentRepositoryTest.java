package com.learning.JPATutorial.repository;

import com.learning.JPATutorial.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    StudentRepository studentRepository;
    @Test
    public void generateTestForStudentCreation(){
        Student student=Student.builder().emailId("abhi@gmail.com").firstName("Abhi")
                .secondName("parmar")
                .gaurdianEmailId("nikhil@gmail.com")
                .gaurdianName("Nikhil")
                .gaurdianMobile("9999999999").build();
        studentRepository.save(student);
    }

}