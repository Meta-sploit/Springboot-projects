package com.springboot.ExceptionHandling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class DepartmentExceptionController {
    @ExceptionHandler(DepartmentNotfoundExpetion.class)
    public ResponseEntity<Object> exeption(DepartmentNotfoundExpetion expetion)
    {
        return new ResponseEntity<>("Not available",HttpStatus.NOT_FOUND);
    }
}
