package com.example.mapstruct.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "task")
@Data
public class Task {
    @Id
    private Long id;
    private String description;
}
