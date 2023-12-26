package com.example.mapstruct.demo;


import com.example.mapstruct.demo.entity.Employee;

import java.util.List;


public interface CriteriaRepository {
    List<Employee> findByFio(String fio);
}