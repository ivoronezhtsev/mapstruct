package com.example.mapstruct.demo.controller;

import com.example.mapstruct.demo.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.ZonedDateTime;

@RestController
@RequiredArgsConstructor
public class SimpleController {

    private final EmployeeService employeeService;

    @GetMapping("/test")
    public String test() {
        return employeeService.getEmployees(ZonedDateTime.now()).toString();
    }

}