package com.learning.JPATutorial.repository;

import com.learning.JPATutorial.entity.Course;
import com.learning.JPATutorial.entity.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseMaterialRepositoryTest {

    @Autowired
    CourseMaterialRepository courseMaterialRepository;

    @Test
    public void saveCourseMaterial(){
        Course course=Course
                .builder()
                .title("abc")
                .credit(12)
                .build();

        CourseMaterial courseMaterial=CourseMaterial
                .builder()
                .url("www.something.com")
                .course(course)
                .build();

        courseMaterialRepository.save(courseMaterial);
    }

}