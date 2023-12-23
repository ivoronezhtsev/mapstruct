package com.example.mapstruct.demo.controller.response;

import com.example.mapstruct.demo.entity.Task;

import java.time.ZonedDateTime;
import java.util.Set;

public record EmployeesResponse(
        Long id,
        String fio,
        ZonedDateTime createDate,
        ZonedDateTime updateDate,

        Set<Task> tasks) {
}