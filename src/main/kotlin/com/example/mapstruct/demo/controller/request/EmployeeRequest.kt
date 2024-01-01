package com.example.mapstruct.demo.controller.request

import com.example.mapstruct.demo.entity.Employee
import com.example.mapstruct.demo.entity.Task

//@JvmRecord
data class EmployeeRequest(val id: Long,
                           val fio: String,
                           val salary: Int,
                           val tasks: Set<Task>
) {
     fun toEntity() = Employee(id, fio, salary, tasks)
}