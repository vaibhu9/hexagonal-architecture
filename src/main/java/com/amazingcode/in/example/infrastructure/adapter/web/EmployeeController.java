package com.amazingcode.in.example.infrastructure.adapter.web;

import com.amazingcode.in.example.infrastructure.adapter.web.dto.request.EmployeeRequest;
import com.amazingcode.in.example.infrastructure.adapter.web.dto.response.EmployeeResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface EmployeeController {

    @PostMapping
    ResponseEntity<EmployeeResponse> createEmployee(@RequestBody EmployeeRequest employeeRequest);

    @GetMapping("/{id}")
    ResponseEntity<EmployeeResponse> getEmployeeById(@PathVariable Long id);

    @GetMapping
    ResponseEntity<List<EmployeeResponse>> getAllEmployees();

    @PutMapping("/{id}")
    ResponseEntity<EmployeeResponse> updateEmployee(@PathVariable Long id, @RequestBody EmployeeRequest employeeRequest);

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteEmployee(@PathVariable Long id);
}
