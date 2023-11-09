package com.springboot.ExceptionHandling;

public class DepartmentNotfoundExpetion extends Exception {

    public DepartmentNotfoundExpetion() {
        super();
    }

    public DepartmentNotfoundExpetion(String message) {
        super(message);
    }

    public DepartmentNotfoundExpetion(String message, Throwable cause) {
        super(message, cause);
    }

    public DepartmentNotfoundExpetion(Throwable cause) {
        super(cause);
    }

    protected DepartmentNotfoundExpetion(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
