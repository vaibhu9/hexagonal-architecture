package com.amazingcode.in.example.infrastructure.adapter.persistence;

import com.amazingcode.in.example.domain.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaEmployeeRepository extends JpaRepository<Employee, Long> {
    boolean existsByEmail(String email);
}
