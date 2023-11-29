package com.learning.JPATutorial.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Table(name = "Student",
        uniqueConstraints=  @UniqueConstraint(
                name = "email_address",
                columnNames = "email_address"
        )
)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Student {

    @Id
    @SequenceGenerator(name = "student_sequence", sequenceName = "student_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_sequence")
    private Long studentId;
    private String firstName;
    private String secondName;
    @Column(name = "email_address", nullable = false)
    private String emailId;
    @Embedded
    private Gaurdian gaurdian;
}
