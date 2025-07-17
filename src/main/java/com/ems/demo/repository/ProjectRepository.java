package com.ems.demo.repository;

import com.ems.demo.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
    // Optional: Custom query methods can be added here
}
