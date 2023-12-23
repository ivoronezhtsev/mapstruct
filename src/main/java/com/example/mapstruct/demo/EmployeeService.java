package com.example.mapstruct.demo;

import com.example.mapstruct.demo.controller.response.EmployeesResponse;
import com.example.mapstruct.demo.entity.Employee;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final Employee2EmployeeResponseMapper employee2EmployeeResponseMapper;

    public List<EmployeesResponse> getEmployees(ZonedDateTime createDate) {
        List<Employee> employees = employeeRepository.findByCreateDate(createDate);
        return employee2EmployeeResponseMapper.toResponse(employees);
    }

}