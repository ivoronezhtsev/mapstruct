package com.example.mapstruct.demo.controller;

import com.example.mapstruct.demo.EmployeeService;
import com.example.mapstruct.demo.controller.request.EmployeeRequest;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.ZonedDateTime;

@RestController
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @Operation(summary = "Получение списка работников по фио")
    @GetMapping("/list")
    public String list(@PathParam(value = "fio") String fio) {
        return employeeService.getEmployeesByFio(fio).toString();
    }

    @PostMapping("/add")
    public void add(@RequestBody EmployeeRequest employeeRequest) {
        employeeService.add(employeeRequest);
    }
}