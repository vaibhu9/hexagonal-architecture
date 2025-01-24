package com.amazingcode.in.example.domain.port.outboundport;

import com.amazingcode.in.example.domain.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository {
    Employee save(Employee employee);
    Optional<Employee> findById(Long id);
    List<Employee> findAll();
    void deleteById(Long id);

    boolean existsByEmail(String email);

    boolean existsById(Long id);
}
