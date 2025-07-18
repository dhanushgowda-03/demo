package com.ems.demo.service;

import com.ems.demo.dto.DepartmentDTO;
import com.ems.demo.entity.Department;

import java.util.List;

public interface DepartmentService {
    Department createDepartment(Department department);

    DepartmentDTO getDepartmentById(Long id);
    List<DepartmentDTO> getAllDepartments();

    Department updateDepartment(Long id, Department department);
    void deleteDepartment(Long id);

    DepartmentDTO convertToDTO(Department department);
}
