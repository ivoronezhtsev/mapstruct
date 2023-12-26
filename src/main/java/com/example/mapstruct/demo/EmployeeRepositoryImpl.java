package com.example.mapstruct.demo;

import com.example.mapstruct.demo.entity.Employee;
import com.example.mapstruct.demo.entity.Employee_;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeRepositoryImpl implements CriteriaRepository {
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<Employee> findByFio(String fio) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Employee> criteriaQuery = criteriaBuilder.createQuery(Employee.class);
        Root<Employee> root = criteriaQuery.from(Employee.class);
        /**
         * Для того чтобы использовать Employee_.FIO - нужен генератор метамодели
         */
        Predicate fioPredicate = criteriaBuilder.equal(root.get(Employee_.FIO), fio);
        criteriaQuery.where(fioPredicate);
        TypedQuery<Employee> query = entityManager.createQuery(criteriaQuery);

        return query.getResultList();
    }
}