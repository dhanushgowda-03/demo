package com.ems.demo.repository;

import com.ems.demo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    // Optional: custom query method
    List<Employee> findByNameContainingIgnoreCase(String name);
}
