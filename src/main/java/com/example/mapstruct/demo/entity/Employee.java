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
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
            // IDENTITY потому что используется ликвибейз, так spring-data берет генератор из СУБД
    )
    private Long id;
    private String fio;
    private Integer salary;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "employee_id")
    private Set<Task> tasks;
}
