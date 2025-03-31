package com.example.abhay.p1.crudapp.services;

import com.example.abhay.p1.crudapp.dto.EmpDto;
import com.example.abhay.p1.crudapp.entities.employeeEntity;
import com.example.abhay.p1.crudapp.repositories.EmployeeRepositories;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    private final EmployeeRepositories employeeRepositories; // Corrected name

    private final ModelMapper modelMapper;

    public EmployeeService(EmployeeRepositories employeeRepositories, ModelMapper modelMapper) {
        this.employeeRepositories = employeeRepositories;
        this.modelMapper = modelMapper;
    }

    public List<EmpDto> findAll() {
        List<employeeEntity> employeeEntity = employeeRepositories.findAll();
        return employeeEntity.stream()
                .map(entity -> modelMapper.map(entity, EmpDto.class))
                .collect(Collectors.toList());
    }

    public EmpDto save(@Valid EmpDto inputemployee) {
        employeeEntity toSaveEntity = modelMapper.map(inputemployee, employeeEntity.class);
        employeeEntity savedEmployeeEntity = employeeRepositories.save(toSaveEntity);
        return modelMapper.map(savedEmployeeEntity, EmpDto.class);
    }

    public Optional<EmpDto> findById(long id) {
//       Optional  <employeeEntity> employeeEntity = employeeRepositories.findById(id).orElse(null);
//        if (employeeEntity == null) {
//            return null;
//        }
        return employeeRepositories.findById(id).map(employeeEntity -> modelMapper.map(employeeEntity, EmpDto.class));
    }

    public EmpDto UpdateEmpById(long id, EmpDto empDto) {
        employeeEntity employeeEntity = modelMapper.map(empDto, employeeEntity.class);
        employeeEntity.setId(id);
        employeeEntity saveEmployeeEntity = employeeRepositories.save(employeeEntity);
        return modelMapper.map(saveEmployeeEntity, EmpDto.class);
    }

    public boolean isExistByID(long ID) {
        return employeeRepositories.existsById(ID);
    }

    public boolean deleteEmployeeByID(long ID) {
        boolean exist = isExistByID(ID);
        if (!exist) return false;
        employeeRepositories.deleteById(ID);
        return true;
    }

    public EmpDto updatePartiallyEmployeeById(long ID, Map<String, Object> update) {
        if (!employeeRepositories.existsById(ID)) {
            return null;
        }

        employeeEntity employeeEntity = employeeRepositories.findById(ID).orElse(null);
        if (employeeEntity == null) {
            return null;
        }

        update.forEach((field, value) -> {
            Field fieldToBeUpdated = ReflectionUtils.findField(employeeEntity.class, field);
            if (fieldToBeUpdated != null) {
                fieldToBeUpdated.setAccessible(true);
                ReflectionUtils.setField(fieldToBeUpdated, employeeEntity, value);
            }
        });

        employeeEntity updatedEmployee = employeeRepositories.save(employeeEntity);
        return modelMapper.map(updatedEmployee, EmpDto.class);
    }
}