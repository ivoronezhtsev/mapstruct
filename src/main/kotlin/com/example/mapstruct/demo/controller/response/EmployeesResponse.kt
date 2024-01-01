package com.example.mapstruct.demo.controller.response

import com.example.mapstruct.demo.entity.Task

//@JvmRecord
data class EmployeesResponse(val id: Long,
                             val fio: String,
                             val salary: Int,
                             val tasks: Set<Task>)