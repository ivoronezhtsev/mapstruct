package com.example.mapstruct.demo.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Table(name = "employee")
@Data
public class Employee {
    @Id
    @GeneratedValue
    private Long id;
    private String fio;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "employee_id")
    private Set<Task> tasks;
}
