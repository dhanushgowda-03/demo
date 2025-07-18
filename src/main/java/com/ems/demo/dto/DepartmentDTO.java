package com.ems.demo.dto;

import java.util.List;

public class DepartmentDTO {
    private Long id;
    private String name;
    private List<EmployeeDTO> employees;

    // Getters
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<EmployeeDTO> getEmployees() {
        return employees;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmployees(List<EmployeeDTO> employees) {
        this.employees = employees;
    }
}
