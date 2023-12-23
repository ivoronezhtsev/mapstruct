package com.example.mapstruct.demo.controller.response;

import com.example.mapstruct.demo.entity.Task;
import jakarta.persistence.criteria.CriteriaBuilder;

import java.time.ZonedDateTime;
import java.util.Set;

public record EmployeesResponse(
        Long id,
        String fio,
        Integer salary,

        Set<Task> tasks) {
}