package com.learning.JPATutorial.repository;

import com.learning.JPATutorial.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
    List<Student> getStudentByfirstName(String Name);

    //here Query will eb defined as per the Model created not on the Table
    // ?1 means matching first letter
    //JPQL
    @Query("Select s from Student s where s.emailId=?1")
    Student getStudentByEmailAddress(String email_address);

    //Native query
    @Query(
            value = "SELECT * FROM student s where s.email_address=?1",
            nativeQuery = true
    )
    Student getStudentByEmailAddressNative(String email_address);

    //Native param query
    @Query(
            value = "SELECT * FROM student s where s.email_address=:emailId",
            nativeQuery = true
    )
    Student getStudentByEmailAddressParamNative(@Param("emailId") String email_address);
}
