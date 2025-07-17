package com.ems.demo.service;

import com.ems.demo.dto.ProjectDTO;

import java.util.List;

public interface ProjectService {
    ProjectDTO createProject(ProjectDTO dto);
    ProjectDTO getProjectById(Long id);
    List<ProjectDTO> getAllProjects();
    void deleteProject(Long id);
}
