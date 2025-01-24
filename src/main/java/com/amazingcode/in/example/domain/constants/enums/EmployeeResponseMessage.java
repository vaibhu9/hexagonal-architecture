package com.amazingcode.in.example.domain.constants.enums;

import lombok.Getter;

@Getter
public enum EmployeeResponseMessage {
    EMPLOYEE_NOT_FOUND("Employee not found with the given ID: %s"),
    EMPLOYEE_DUPLICATE("An employee with the same details already exists."),
    EMPLOYEE_INVALID_ARGUMENT("Invalid arguments provided for employee operation."),
    EMPLOYEE_DELETE_ERROR("Error occurred while deleting the employee.");

    private final String message;

    EmployeeResponseMessage(String message) {
        this.message = message;
    }

    public String getMessage(Long id) {
        return String.format(message, id);
    }
}
