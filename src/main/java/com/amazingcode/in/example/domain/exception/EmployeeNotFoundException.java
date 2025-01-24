package com.amazingcode.in.example.domain.exception;

import lombok.Getter;

@Getter
public class EmployeeNotFoundException extends RuntimeException {

    private final String exceptionMessage;

    public EmployeeNotFoundException(String message) {
        super(message);
        this.exceptionMessage = message;
    }
}
