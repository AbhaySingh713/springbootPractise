package com.example.abhay.p1.crudapp.controllers;

import com.example.abhay.p1.crudapp.dto.EmpDto;
import com.example.abhay.p1.crudapp.entities.employeeEntity;
import com.example.abhay.p1.crudapp.services.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(path = "/emp")
public class EmployeeController {

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    private final EmployeeService employeeService;



    @GetMapping(path = "/{Id}")
    public  ResponseEntity<EmpDto> getEmployeename(@PathVariable long Id) {
        Optional<EmpDto> empDto = employeeService.findById(Id);
        return empDto
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<EmpDto>> getList()
    {
        return ResponseEntity.ok(employeeService.findAll()) ;
    }

    @PostMapping
    public ResponseEntity<EmpDto> CreatenewEmp(@RequestBody  @Valid EmpDto inputemployee){
        EmpDto saveEmp =  employeeService.save(inputemployee);
        return new ResponseEntity<>(saveEmp, HttpStatus.CREATED);
    }

    @PutMapping(path="/{ID}")
    public ResponseEntity<EmpDto> UpdateEmpById(@RequestBody EmpDto empDto,@PathVariable long ID){
        return ResponseEntity.ok( employeeService.UpdateEmpById(ID,empDto));
    }

    @DeleteMapping(path = "/{ID}")
    public ResponseEntity<Boolean> deleteEmployeeById(@PathVariable long ID){
       boolean gotDeleted =   employeeService.deleteEmployeeByID(ID);
       if(gotDeleted) return ResponseEntity.ok(true);
       else return ResponseEntity.notFound().build();
    }

    @PatchMapping(path="/{ID}")
    public ResponseEntity<EmpDto> updatePartiallyEmployeeById(@RequestBody Map<String,Object>update,@PathVariable long ID){
        EmpDto empDto1 =  employeeService.updatePartiallyEmployeeById(ID,update);
        if(empDto1==null) return ResponseEntity.notFound().build();
        else  return ResponseEntity.ok(empDto1);
    }
}