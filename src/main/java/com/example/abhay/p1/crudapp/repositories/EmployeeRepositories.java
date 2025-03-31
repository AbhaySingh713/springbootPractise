package com.example.abhay.p1.crudapp.repositories;

import com.example.abhay.p1.crudapp.entities.employeeEntity;
import org.springframework.data.jpa.repository.JpaRepository; // Use JpaRepository, not JpaRepositoryImplementation
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepositories extends JpaRepository<employeeEntity, Long> {
    // You can add custom query methods here if needed
}