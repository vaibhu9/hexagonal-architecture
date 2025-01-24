package com.amazingcode.in.example.infrastructure.adapter.web.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse {
    private int errorStatusCode;
    private String errorStatus;
    private String errorMessage;
}
