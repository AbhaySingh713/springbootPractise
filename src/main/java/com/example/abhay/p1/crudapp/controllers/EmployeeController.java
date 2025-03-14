package com.example.abhay.p1.crudapp.controllers;

import com.example.abhay.p1.crudapp.dto.EmpDto;
import com.example.abhay.p1.crudapp.entities.employeeEntity;
import com.example.abhay.p1.crudapp.repositories.EmployeeRepositories;
import org.springframework.web.bind.annotation.*;
import java.util.*;
import java.time.LocalDate;

@RestController
@RequestMapping(path = "/emp")
public class EmployeeController {

    private final EmployeeRepositories employeeRepositories;

    public EmployeeController(EmployeeRepositories employeeRepositories) {
        this.employeeRepositories = employeeRepositories;
    }

    @GetMapping(path = "/{EmpId}")
    public employeeEntity getEmployeename(@PathVariable long EmpId) {
        return employeeRepositories.findById(EmpId).orElse(null); // Corrected line
    }
    @GetMapping
    public List<employeeEntity> getList(){
        return employeeRepositories.findAll();
    }

    @PostMapping
    public employeeEntity CreatenewEmp(@RequestBody employeeEntity inputemployee){
        return employeeRepositories.save(inputemployee); // Corrected line
    }
}