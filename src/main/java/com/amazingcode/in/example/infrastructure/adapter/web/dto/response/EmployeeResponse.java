package com.amazingcode.in.example.infrastructure.adapter.web.dto.response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class EmployeeResponse {
    private Long id;
    private String name;
    private String email;
    private String contact;
    private Double salary;
}
