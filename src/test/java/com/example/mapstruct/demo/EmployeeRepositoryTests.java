package com.example.mapstruct.demo;


import com.example.mapstruct.demo.entity.Employee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class EmployeeRepositoryTests {

    @Autowired
    private EmployeeRepository employeeRepository;
    @Test
    void testFindByFio() {
        Employee homer = new Employee();
        homer.setFio("Homer Simpson");
        homer.setSalary(1000000);
        employeeRepository.save(homer);

        Employee actual = employeeRepository.findByFio("Homer Simpson").getFirst();
        actual.setId(null);

        Assertions.assertEquals(homer, actual);
    }
}
