package com.example.abhay.p1.crudapp.repositories;

import com.example.abhay.p1.crudapp.entities.employeeEntity;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepositories extends JpaRepositoryImplementation<employeeEntity, Long>{

}
