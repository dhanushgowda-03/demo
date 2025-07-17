package com.ems.demo.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    // Many employees can work on the same project
    @OneToMany(mappedBy = "project")
    private List<Employee> employees;

    // Each project belongs to one department
    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    // Constructors
    public Project() {}

    public Project(String name, Department department) {
        this.name = name;
        this.department = department;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
