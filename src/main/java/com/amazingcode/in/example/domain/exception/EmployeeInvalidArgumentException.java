package com.amazingcode.in.example.domain.exception;

import lombok.Getter;

@Getter
public class EmployeeInvalidArgumentException extends RuntimeException {

    private final String exceptionMessage;

    public EmployeeInvalidArgumentException(String message) {
        super(message);
        this.exceptionMessage = message;
    }
}
