package com.ahsansoftware.lms.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class StudentRequestDTO {

    @NotBlank(message = "Name is Required")
    @Size(min = 2 , max = 50 , message = "Name must be between 2 and 50 characters")
    private String name;

    @NotBlank(message = "Email is Required")
    @Email(message = "Enter a Valid Email")
    private String email;

    public StudentRequestDTO() {}

    public StudentRequestDTO(String name , String email){
        this.name = name;
        this.email = email;
    }

    public String getName(){ return name; }
    public void setName(String name){
        this.name = name;
    }

    public String getEmail(){ return email; }
    public void setEmail(String email){
        this.email = email;
    }
}
