package com.example.mapstruct.demo

import com.example.mapstruct.demo.controller.request.EmployeeRequest
import com.example.mapstruct.demo.controller.response.EmployeesResponse
import com.example.mapstruct.demo.entity.Employee
import org.springframework.stereotype.Service

@Service
class EmployeeService(val employeeRepository: EmployeeRepository) {

    fun getEmployeesByFio(fio: String?): List<EmployeesResponse?>? {
        val employees: List<Employee?>? = employeeRepository.findByFio(fio)
        employees?.map { it?.toResponse() }?.toList()
        return employees?.map { it?.toResponse() }?.toList()
    }

    fun add(employeeRequest: EmployeeRequest?) {
        val employee = employeeRequest?.toEntity()
        employee?.let {
            employeeRepository.save(it)
        }
    }
}