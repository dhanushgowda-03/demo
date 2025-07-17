package com.ems.demo.service.impl;

import com.ems.demo.dto.ProjectDTO;
import com.ems.demo.entity.Department;
import com.ems.demo.entity.Project;
import com.ems.demo.exception.ResourceNotFoundException;
import com.ems.demo.repository.DepartmentRepository;
import com.ems.demo.repository.ProjectRepository;
import com.ems.demo.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public ProjectDTO createProject(ProjectDTO dto) {
        Department department = departmentRepository.findById(dto.getDepartmentId())
                .orElseThrow(() -> new ResourceNotFoundException("Department", "id", dto.getDepartmentId()));

        Project project = new Project();
        project.setName(dto.getName());
        project.setDepartment(department);

        Project saved = projectRepository.save(project);
        return mapToDTO(saved);
    }

    @Override
    public ProjectDTO getProjectById(Long id) {
        Project project = projectRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Project", "id", id));
        return mapToDTO(project);
    }

    @Override
    public List<ProjectDTO> getAllProjects() {
        return projectRepository.findAll().stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteProject(Long id) {
        Project project = projectRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Project", "id", id));
        projectRepository.delete(project);
    }

    // ✅ DTO Mapper
    private ProjectDTO mapToDTO(Project project) {
        ProjectDTO dto = new ProjectDTO();
        dto.setId(project.getId());
        dto.setName(project.getName());
        dto.setDepartmentId(project.getDepartment().getId());
        return dto;
    }
}
