package com.ems.demo.service.impl;

import com.ems.demo.entity.Employee;
import com.ems.demo.exception.ResourceNotFoundException;
import com.ems.demo.repository.EmployeeRepository;
import com.ems.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;


import java.util.List;


import com.ems.demo.dto.EmployeeDTO;
import com.ems.demo.repository.DepartmentRepository;
import com.ems.demo.repository.ProjectRepository;
import com.ems.demo.entity.Department;
import com.ems.demo.entity.Project;


@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private PasswordEncoder passwordEncoder;
    private EmployeeRepository employeeRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public EmployeeDTO createEmployee(EmployeeDTO dto) {
        Department department = departmentRepository.findById(dto.getDepartmentId())
                .orElseThrow(() -> new ResourceNotFoundException("Department", "id", dto.getDepartmentId()));

        Project project = projectRepository.findById(dto.getProjectId())
                .orElseThrow(() -> new ResourceNotFoundException("Project", "id", dto.getProjectId()));

        Employee employee = new Employee();
        employee.setName(dto.getName());
        employee.setEmail(dto.getEmail());
        employee.setPassword(passwordEncoder.encode(dto.getPassword())); // 👈 add this line
        employee.setDepartment(department);
        employee.setProject(project);

        Employee saved = employeeRepository.save(employee);
        return mapToDTO(saved);
    }


    @Override
    public List<EmployeeDTO> getAllEmployees() {
        return employeeRepository.findAll().stream()
                .map(this::mapToDTO)
                .toList();
    }

    @Override
    public EmployeeDTO getEmployeeById(Long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee", "id", id));
        return mapToDTO(employee);
    }

    @Override
    public EmployeeDTO updateEmployee(Long id, EmployeeDTO dto) {
        Employee existing = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee", "id", id));

        existing.setName(dto.getName());
        existing.setEmail(dto.getEmail());

        Department department = departmentRepository.findById(dto.getDepartmentId())
                .orElseThrow(() -> new ResourceNotFoundException("Department", "id", dto.getDepartmentId()));

        Project project = projectRepository.findById(dto.getProjectId())
                .orElseThrow(() -> new ResourceNotFoundException("Project", "id", dto.getProjectId()));

        existing.setDepartment(department);
        existing.setProject(project);

        return mapToDTO(employeeRepository.save(existing));
    }

    @Override
    public void deleteEmployee(Long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee", "id", id));
        employeeRepository.delete(employee);
    }

    @Override
    public EmployeeDTO moveEmployeeDept(Long id, EmployeeDTO dto) {
        Employee existing = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee", "id", id));

        existing.setName(dto.getName());
        existing.setEmail(dto.getEmail());

        Department department = departmentRepository.findById(dto.getDepartmentId())
                .orElseThrow(() -> new ResourceNotFoundException("Department", "id", dto.getDepartmentId()));
        existing.setDepartment(department);
        return mapToDTO(employeeRepository.save(existing));
    }

    private EmployeeDTO mapToDTO(Employee emp) {
        EmployeeDTO dto = new EmployeeDTO();
        dto.setId(emp.getId());
        dto.setName(emp.getName());
        dto.setEmail(emp.getEmail());
        dto.setDepartmentId(emp.getDepartment().getId());
        dto.setProjectId(emp.getProject().getId());
        return dto;
    }
}
