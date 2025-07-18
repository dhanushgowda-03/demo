package com.ems.demo.controller;

import com.ems.demo.dto.DepartmentDTO;
import com.ems.demo.entity.Department;
import com.ems.demo.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    // ✅ Create a department (accepts entity for now)
    @PostMapping
    public ResponseEntity<DepartmentDTO> createDepartment(@RequestBody Department department) {
        Department created = departmentService.createDepartment(department);
        DepartmentDTO dto = departmentService.convertToDTO(created);
        return ResponseEntity.ok(dto);
    }

    // ✅ Get all departments with employee list
    @GetMapping
    public List<DepartmentDTO> getAllDepartments() {
        return departmentService.getAllDepartments();
    }

    // ✅ Get department by ID
    @GetMapping("/{id}")
    public DepartmentDTO getDepartmentById(@PathVariable Long id) {
        return departmentService.getDepartmentById(id);
    }

    // ✅ Delete department by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDepartment(@PathVariable Long id) {
        departmentService.deleteDepartment(id);
        return ResponseEntity.noContent().build();
    }
}
