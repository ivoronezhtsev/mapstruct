package com.example.mapstruct.demo;

import com.example.mapstruct.demo.entity.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Integer>, CriteriaRepository {
}
