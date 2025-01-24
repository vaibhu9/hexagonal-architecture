package com.amazingcode.in.example.application.usecase;

import com.amazingcode.in.example.domain.constants.enums.EmployeeResponseMessage;
import com.amazingcode.in.example.domain.exception.*;
import com.amazingcode.in.example.domain.model.Employee;
import com.amazingcode.in.example.domain.port.inboundport.EmployeeService;
import com.amazingcode.in.example.domain.port.outboundport.EmployeeRepository;
import com.amazingcode.in.example.infrastructure.adapter.web.dto.request.EmployeeRequest;
import com.amazingcode.in.example.infrastructure.adapter.web.dto.response.EmployeeResponse;
import com.amazingcode.in.example.infrastructure.mapper.EmployeeMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public EmployeeResponse createEmployee(EmployeeRequest employeeRequest) {
        validateEmployeeRequest(employeeRequest);

        if (employeeRepository.existsByEmail(employeeRequest.getEmail())) {
            throw new EmployeeDuplicateException(EmployeeResponseMessage.EMPLOYEE_DUPLICATE.getMessage());
        }

        Employee toSaveEmployee = EmployeeMapper.INSTANCE.toEntity(employeeRequest);
        return EmployeeMapper.INSTANCE.toResponse(employeeRepository.save(toSaveEmployee));
    }

    @Override
    public EmployeeResponse getEmployeeById(Long id) {
        return employeeRepository.findById(id)
                .map(EmployeeMapper.INSTANCE::toResponse)
                .orElseThrow(() -> new EmployeeNotFoundException(EmployeeResponseMessage.EMPLOYEE_NOT_FOUND.getMessage(id)));
    }

    @Override
    public List<EmployeeResponse> getAllEmployees() {
        return EmployeeMapper.INSTANCE.toResponseList(employeeRepository.findAll());
    }

    @Override
    public EmployeeResponse updateEmployee(Long id, EmployeeRequest employeeRequest) {
        validateEmployeeRequest(employeeRequest);

        Optional<Employee> existedEmployee = employeeRepository.findById(id);
        if (existedEmployee.isEmpty()) {
            throw new EmployeeNotFoundException(EmployeeResponseMessage.EMPLOYEE_NOT_FOUND.getMessage(id));
        }

        if (employeeRepository.existsByEmail(employeeRequest.getEmail())) {
            throw new EmployeeDuplicateException(EmployeeResponseMessage.EMPLOYEE_DUPLICATE.getMessage());
        }

        Employee toUpdateEmployee = EmployeeMapper.INSTANCE.toEntity(employeeRequest);
        toUpdateEmployee.setId(id);
        return EmployeeMapper.INSTANCE.toResponse(employeeRepository.save(toUpdateEmployee));
    }

    @Override
    public void deleteEmployee(Long id) {
        if (!employeeRepository.existsById(id)) {
            throw new EmployeeNotFoundException(
                    String.format(EmployeeResponseMessage.EMPLOYEE_NOT_FOUND.getMessage(), id)
            );
        }
        try {
            employeeRepository.deleteById(id);
        } catch (Exception e) {
            throw new EmployeeDeleteException(EmployeeResponseMessage.EMPLOYEE_DELETE_ERROR.getMessage());
        }
    }

    private void validateEmployeeRequest(EmployeeRequest employeeRequest) {
        if (employeeRequest.getName() == null || employeeRequest.getName().isEmpty()) {
            throw new EmployeeInvalidArgumentException(EmployeeResponseMessage.EMPLOYEE_INVALID_ARGUMENT.getMessage());
        }
        if (employeeRequest.getEmail() == null || !employeeRequest.getEmail().matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
            throw new EmployeeInvalidArgumentException(EmployeeResponseMessage.EMPLOYEE_INVALID_ARGUMENT.getMessage());
        }
        if (employeeRequest.getContact() == null || employeeRequest.getContact().length() < 10) {
            throw new EmployeeInvalidArgumentException(EmployeeResponseMessage.EMPLOYEE_INVALID_ARGUMENT.getMessage());
        }
        if (employeeRequest.getSalary() == null || employeeRequest.getSalary() <= 0) {
            throw new EmployeeInvalidArgumentException(EmployeeResponseMessage.EMPLOYEE_INVALID_ARGUMENT.getMessage());
        }
    }
}
