package com.ems.demo.dto;

public class EmployeeDTO {
    private Long id;
    private String name;
    private String email;
    private Long departmentId;
    private Long projectId;

    // Getters
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public Long getProjectId() {
        return projectId;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }
}
