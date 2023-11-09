package com.springboot.ExceptionHandling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.springboot.entity.Exception;

@ControllerAdvice
@ResponseStatus
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(DepartmentNotfoundExpetion.class)
    public ResponseEntity<Exception> exeption(DepartmentNotfoundExpetion departmentNotfoundExpetion) {
        Exception exception= new Exception(HttpStatus.NOT_FOUND,departmentNotfoundExpetion.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception);
    }
}
