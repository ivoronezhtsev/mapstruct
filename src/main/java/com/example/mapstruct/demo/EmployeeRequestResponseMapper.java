package com.example.mapstruct.demo;

import com.example.mapstruct.demo.controller.request.EmployeeRequest;
import com.example.mapstruct.demo.controller.response.EmployeesResponse;
import com.example.mapstruct.demo.entity.Employee;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EmployeeRequestResponseMapper {
    List<EmployeesResponse> toResponse(List<Employee> source);

    Employee toEntity(EmployeeRequest request);
}