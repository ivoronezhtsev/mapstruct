package com.example.mapstruct.demo;


import com.example.mapstruct.demo.entity.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {
    @Query("select e from Employee e where e.fio = :fio")
    List<Employee> findByFio(String fio);
}