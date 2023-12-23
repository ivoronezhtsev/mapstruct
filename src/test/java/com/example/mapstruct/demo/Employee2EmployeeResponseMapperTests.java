package com.example.mapstruct.demo;

import com.example.mapstruct.demo.controller.response.EmployeesResponse;
import com.example.mapstruct.demo.entity.Employee;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Employee2EmployeeResponseMapperTests {
    @Test
    public void testMapper() {
        Employee2EmployeeResponseMapper mapper = Mappers.getMapper(Employee2EmployeeResponseMapper.class);
        List<Employee> employees = new ArrayList<>();;
        Employee employee = new Employee();
        employee.setId(0L);
        employee.setFio("fio");
        employees.add(employee);
        List<EmployeesResponse> response = mapper.toResponse(employees);
        assertTrue(response.contains(new EmployeesResponse(0L, "fio", null, null, null)));
    }
}
