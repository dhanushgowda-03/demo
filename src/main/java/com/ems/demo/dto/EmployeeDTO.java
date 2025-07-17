package com.ems.demo.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class EmployeeDTO {

    @NotBlank
    private String name;

    @Email
    private String email;

    @NotNull
    private Long departmentId;

    @NotNull
    private Long projectId;

    // Getters and Setters
}
