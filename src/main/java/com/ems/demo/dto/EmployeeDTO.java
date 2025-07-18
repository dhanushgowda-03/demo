package com.ems.demo.dto;

public class EmployeeDTO {
    private Long id;
    private String name;
    private String email;
    private Long departmentId;
    private Long projectId;
    private String username;
    private String password;
// + add getter/setter

// + add getter/setter


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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
