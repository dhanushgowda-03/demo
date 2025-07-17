package com.ems.demo.service;

import com.ems.demo.dto.EmployeeDTO;
import com.ems.demo.entity.Employee;
import java.util.List;

// EmployeeService.java
public interface EmployeeService {
    EmployeeDTO createEmployee(EmployeeDTO dto);
    List<EmployeeDTO> getAllEmployees();
    EmployeeDTO getEmployeeById(Long id);
    EmployeeDTO updateEmployee(Long id, EmployeeDTO dto);
    void deleteEmployee(Long id);
}
