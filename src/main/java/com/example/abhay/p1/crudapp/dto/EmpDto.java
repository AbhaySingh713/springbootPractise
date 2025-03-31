package com.example.abhay.p1.crudapp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;
@Data
public class EmpDto {
  private   long id;
  @NotNull(message = "there should be a name there")
    private String name;
   private Integer age;
   @Email
    private String email;
    private LocalDate dateOfJoin;
    @JsonProperty("isActive")
    private Boolean isActive;



}
