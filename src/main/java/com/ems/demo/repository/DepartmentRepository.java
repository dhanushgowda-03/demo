package com.ems.demo.repository;

import com.ems.demo.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
    // Optional: Custom query methods can be added here
}
