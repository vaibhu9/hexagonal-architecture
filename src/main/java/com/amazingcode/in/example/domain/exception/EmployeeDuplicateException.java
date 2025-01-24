package com.amazingcode.in.example.domain.exception;

import lombok.Getter;

@Getter
public class EmployeeDuplicateException extends RuntimeException {

    private final String exceptionMessage;

    public EmployeeDuplicateException(String message) {
        super(message);
        this.exceptionMessage = message;
    }
}
