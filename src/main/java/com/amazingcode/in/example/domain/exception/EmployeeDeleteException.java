package com.amazingcode.in.example.domain.exception;

import lombok.Getter;

@Getter
public class EmployeeDeleteException extends RuntimeException {

    private final String exceptionMessage;

    public EmployeeDeleteException(String message) {
        super(message);
        this.exceptionMessage = message;
    }
}
