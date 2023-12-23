package com.example.mapstruct.demo;

import com.example.mapstruct.demo.controller.response.EmployeesResponse;
import com.example.mapstruct.demo.entity.Employee;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface Employee2EmployeeResponseMapper {
    List<EmployeesResponse> toResponse(List<Employee> source);
}