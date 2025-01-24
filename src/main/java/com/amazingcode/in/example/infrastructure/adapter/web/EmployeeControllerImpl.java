package com.amazingcode.in.example.infrastructure.adapter.web;

import com.amazingcode.in.example.domain.port.inboundport.EmployeeService;
import com.amazingcode.in.example.infrastructure.adapter.web.dto.request.EmployeeRequest;
import com.amazingcode.in.example.infrastructure.adapter.web.dto.response.EmployeeResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeControllerImpl implements EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeControllerImpl(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @Override
    public ResponseEntity<EmployeeResponse> createEmployee(EmployeeRequest employeeRequest) {
        return ResponseEntity.ok(employeeService.createEmployee(employeeRequest));
    }

    @Override
    public ResponseEntity<EmployeeResponse> getEmployeeById(Long id) {
        return ResponseEntity.ok(employeeService.getEmployeeById(id));
    }

    @Override
    public ResponseEntity<List<EmployeeResponse>> getAllEmployees() {
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

    @Override
    public ResponseEntity<EmployeeResponse> updateEmployee(Long id, EmployeeRequest employeeRequest) {
        return ResponseEntity.ok(employeeService.updateEmployee(id,employeeRequest));
    }

    @Override
    public ResponseEntity<Void> deleteEmployee(Long id) {
        employeeService.deleteEmployee(id);
        return ResponseEntity.noContent().build();
    }
}
