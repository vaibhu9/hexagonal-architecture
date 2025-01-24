package com.amazingcode.in.example.domain.port.inboundport;

import com.amazingcode.in.example.infrastructure.adapter.web.dto.request.EmployeeRequest;
import com.amazingcode.in.example.infrastructure.adapter.web.dto.response.EmployeeResponse;

import java.util.List;

public interface EmployeeService {
    EmployeeResponse createEmployee(EmployeeRequest employeeRequest);
    EmployeeResponse getEmployeeById(Long id);
    List<EmployeeResponse> getAllEmployees();
    EmployeeResponse updateEmployee(Long id, EmployeeRequest employeeRequest);
    void deleteEmployee(Long id);
}
