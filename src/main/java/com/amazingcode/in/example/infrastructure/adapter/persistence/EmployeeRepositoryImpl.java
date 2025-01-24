package com.amazingcode.in.example.infrastructure.adapter.persistence;

import com.amazingcode.in.example.domain.model.Employee;
import com.amazingcode.in.example.domain.port.outboundport.EmployeeRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {

    private final JpaEmployeeRepository employeeRepository;

    public EmployeeRepositoryImpl(JpaEmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Optional<Employee> findById(Long id) {
        return employeeRepository.findById(id);
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public boolean existsByEmail(String email) {
        return employeeRepository.existsByEmail(email);
    }

    @Override
    public boolean existsById(Long id) {
        return employeeRepository.existsById(id);
    }
}
