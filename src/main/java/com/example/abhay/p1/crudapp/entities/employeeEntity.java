package com.example.abhay.p1.crudapp.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.time.LocalDate;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="Employee")
public class employeeEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO )
    private   long id;
    private String name;
    private Integer age;
    private String email;
    private LocalDate dateOfJoin;
    private Boolean isActive;

}
