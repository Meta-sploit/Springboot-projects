package com.learning.JPATutorial.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CourseMaterial {

    @SequenceGenerator(
            name = "coursematerial_sequence",
            sequenceName = "coursematerial_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "coursematerial_sequence"
    )
    @Id
    private Long courseMaterialId;
    private String url;
}