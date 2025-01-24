package com.amazingcode.in.example.infrastructure.mapper;

import com.amazingcode.in.example.domain.model.Employee;
import com.amazingcode.in.example.infrastructure.adapter.web.dto.request.EmployeeRequest;
import com.amazingcode.in.example.infrastructure.adapter.web.dto.response.EmployeeResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface EmployeeMapper {
    EmployeeMapper INSTANCE = Mappers.getMapper(EmployeeMapper.class);

    Employee toEntity(EmployeeRequest request);

    EmployeeResponse toResponse(Employee employee);

    List<EmployeeResponse> toResponseList(List<Employee> employees);
}
