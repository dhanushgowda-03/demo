package com.ems.demo.service.impl;

import com.ems.demo.dto.DepartmentDTO;
import com.ems.demo.dto.EmployeeDTO;
import com.ems.demo.entity.Department;
import com.ems.demo.entity.Employee;
import com.ems.demo.exception.ResourceNotFoundException;
import com.ems.demo.repository.DepartmentRepository;
import com.ems.demo.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Department createDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public DepartmentDTO getDepartmentById(Long id) {
        Department department = departmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Department", "id", id));
        return convertToDTO(department);
    }

    @Override
    public List<DepartmentDTO> getAllDepartments() {
        return departmentRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Department updateDepartment(Long id, Department updatedDepartment) {
        Department existing = departmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Department", "id", id));
        existing.setName(updatedDepartment.getName());
        return departmentRepository.save(existing);
    }

    @Override
    public void deleteDepartment(Long id) {
        Department department = departmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Department", "id", id));
        departmentRepository.delete(department);
    }

    @Override
    public DepartmentDTO convertToDTO(Department department) {
        DepartmentDTO dto = new DepartmentDTO();
        dto.setId(department.getId());
        dto.setName(department.getName());

        // Convert associated employees if they exist
        if (department.getEmployees() != null) {
            List<EmployeeDTO> employeeDTOs = department.getEmployees().stream().map(emp -> {
                EmployeeDTO empDTO = new EmployeeDTO();
                empDTO.setId(emp.getId());
                empDTO.setName(emp.getName());
                empDTO.setEmail(emp.getEmail());
                empDTO.setUsername(emp.getUsername());
                empDTO.setDepartmentId(
                        emp.getDepartment() != null ? emp.getDepartment().getId() : null);
                empDTO.setProjectId(
                        emp.getProject() != null ? emp.getProject().getId() : null);
                // Don't expose password
                return empDTO;
            }).collect(Collectors.toList());

            dto.setEmployees(employeeDTOs);
        }

        return dto;
    }
}
