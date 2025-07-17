package com.ems.demo.service;

import com.ems.demo.entity.Department;

import java.util.List;

public interface DepartmentService {
    Department createDepartment(Department department);
    Department getDepartmentById(Long id);
    List<Department> getAllDepartments();
    Department updateDepartment(Long id, Department updatedDepartment);
    void deleteDepartment(Long id);
}
