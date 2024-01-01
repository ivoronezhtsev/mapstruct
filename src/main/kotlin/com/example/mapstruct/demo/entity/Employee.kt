package com.example.mapstruct.demo.entity
import com.example.mapstruct.demo.controller.response.EmployeesResponse
import jakarta.persistence.*

@Entity
@Table(name = "employee")
class Employee() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private var id: Long? = null
    private var fio: String? = null
    private var salary: Int? = null

    @OneToMany(cascade = [CascadeType.ALL])
    @JoinColumn(name = "employee_id")
    private var tasks: Set<Task>? = null
    constructor(id: Long, fio: String, salary: Int?, tasks: Set<Task>) : this() {
        this.id = id
        this.fio = fio
        this.salary = salary
        this.tasks = tasks
    }

    fun toResponse() = EmployeesResponse(id ?: 0, fio ?: "", salary ?: 0, tasks ?: emptySet())
}
