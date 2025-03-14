package com.example.abhay.p1.crudapp.dto;

import java.time.LocalDate;

public class EmpDto {
  private   long id;
    private String name;
   private Integer age;
    private String email;
    private LocalDate dateOfJoin;
    private Boolean isActive;

    public EmpDto(){

    }

    public EmpDto(long id, String name, Integer age, String email, LocalDate dateOfJoin, boolean isActive) {
//        System.out.println("Constructor called with id: " + id + ", isActive: " + isActive); // Add this line
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
        this.dateOfJoin = dateOfJoin;
        this.isActive = isActive;
    }


    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDateofjoin() {
        return dateOfJoin;
    }

    public void setDateofjoin(LocalDate dateofjoin) {
        this.dateOfJoin = dateofjoin;
    }

    public Boolean getIsactive() {
        return isActive;
    }

    public void setIsactive(Boolean isactive) {
        isActive = isactive;
    }


}
