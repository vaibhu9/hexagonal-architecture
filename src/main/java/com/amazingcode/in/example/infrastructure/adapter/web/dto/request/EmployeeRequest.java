package com.amazingcode.in.example.infrastructure.adapter.web.dto.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class EmployeeRequest {
    private String name;
    private String email;
    private String contact;
    private Double salary;
}
