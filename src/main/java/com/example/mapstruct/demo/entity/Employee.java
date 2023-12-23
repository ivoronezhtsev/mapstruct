package com.example.mapstruct.demo.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.ZonedDateTime;
import java.util.Set;

@Entity
@Table(name = "employee")
@Data
public class Employee {
    @Id
    @GeneratedValue
    private Long id;
    private String fio;
    private ZonedDateTime createDate;
    private ZonedDateTime updateDate;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "employee_id")
    private Set<Task> tasks;
}
