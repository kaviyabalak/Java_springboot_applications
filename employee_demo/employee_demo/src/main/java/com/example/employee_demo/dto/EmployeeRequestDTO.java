package com.example.employee_demo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class EmployeeRequestDTO {


    private Long id;
    @NotBlank(message = "Name is Required")
    private String name;

    @NotNull(message = "Invalid Email Format")
    private String email;

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

}
