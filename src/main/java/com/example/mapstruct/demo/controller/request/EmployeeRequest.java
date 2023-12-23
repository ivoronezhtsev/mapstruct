package com.example.mapstruct.demo.controller.request;

import com.example.mapstruct.demo.entity.Task;

import java.util.Set;

public record EmployeeRequest(Long id,
        String fio,
        Integer salary,
        Set<Task> tasks
) {
}
