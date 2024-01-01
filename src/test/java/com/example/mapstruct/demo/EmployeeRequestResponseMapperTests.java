package com.example.mapstruct.demo;

import com.example.mapstruct.demo.controller.request.EmployeeRequest;
import com.example.mapstruct.demo.controller.response.EmployeesResponse;
import com.example.mapstruct.demo.entity.Employee;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class EmployeeRequestResponseMapperTests {

    private static final EmployeeRequestResponseMapper mapper = Mappers.getMapper(EmployeeRequestResponseMapper.class);
    @Test
    public void testToResponse() {
        List<Employee> employees = new ArrayList<>();;
        Employee employee = new Employee();
        employee.setId(0L);
        employee.setFio("fio");
        employee.setSalary(220000);
        employee.setTasks(Collections.emptySet());
        employees.add(employee);
        List<EmployeesResponse> response = mapper.toResponse(employees);
        assertTrue(response.contains(new EmployeesResponse(0L, "fio", 220000, Collections.emptySet())));
    }

    @Test
    public void testToEntity() {
        EmployeeRequest request = new EmployeeRequest(0L, "fio", 440000, Collections.emptySet());
        Employee employee = mapper.toEntity(request);
        assertNotNull(employee);
        assertEquals(0, employee.getId());
        assertEquals("fio", employee.getFio());
        assertEquals(440000, employee.getSalary());
        assertEquals(Collections.emptySet(), employee.getTasks());
    }
}
