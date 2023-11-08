package com.springboot.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data  
// @Data annotation will create getter setters tostring methods 
@NoArgsConstructor
@AllArgsConstructor
@Builder
// @Builder annotation will implement the  Builder pattern for the Department class
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long departmentId;
    @NotBlank(message = "departmentName cannot be blank")
    String departmentName;
    String departmentAddress;
    String departmentCode;
}
