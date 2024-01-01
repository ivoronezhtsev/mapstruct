package com.example.mapstruct.demo.entity

import jakarta.persistence.*

@Entity
@Table(name = "task")
class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private val id: Long? = null
    private val description: String? = null

    override fun toString() = "(id = $id, description = $description)"
}
