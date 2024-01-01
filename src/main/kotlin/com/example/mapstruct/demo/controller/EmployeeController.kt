package com.example.mapstruct.demo.controller

import com.example.mapstruct.demo.EmployeeService
import com.example.mapstruct.demo.controller.request.EmployeeRequest
import io.swagger.v3.oas.annotations.Operation
import jakarta.websocket.server.PathParam
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController


@RestController
class EmployeeController(val employeeService: EmployeeService) {
    @Operation(summary = "Получение списка работников по фио")
    @GetMapping("/list")
    fun list(@PathParam(value = "fio") fio: String?): String {
        return employeeService.getEmployeesByFio(fio).toString()
    }

    @Operation(summary = "Добавить работника")
    @PostMapping("/add")
    fun add(@RequestBody employeeRequest: EmployeeRequest?) {
        employeeService.add(employeeRequest)
    }
}