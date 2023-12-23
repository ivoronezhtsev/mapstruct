package com.example.mapstruct.demo;

import com.example.mapstruct.demo.controller.request.EmployeeRequest;
import com.example.mapstruct.demo.controller.response.EmployeesResponse;
import com.example.mapstruct.demo.entity.Employee;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final EmployeeRequestResponseMapper employeeRequestResponseMapper;

    public List<EmployeesResponse> getEmployeesByFio(String fio) {
        List<Employee> employees = employeeRepository.findByFio(fio);
        return employeeRequestResponseMapper.toResponse(employees);
    }

    public void add(EmployeeRequest employeeRequest) {
        Employee employee = employeeRequestResponseMapper.toEntity(employeeRequest);
        employeeRepository.save(employee);
    }
}