package com.example.authservice.service.serviceImpl;

import com.example.authservice.model.Project;
import com.example.authservice.repository.ProjectRepository;
import com.example.authservice.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

@Service

public class ProjectServiceImpl implements ProjectService {

    private ProjectRepository projectRepository;

    @Autowired
    public ProjectServiceImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public ResponseEntity addProject(Project project, Principal principal, HttpServletRequest request) {
        try {
            projectRepository.save(project);
            return ResponseEntity.ok().body("Project added successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Project could not be added");
        }
    }

    @Override
    public ResponseEntity updateProject(Project project, Principal principal, HttpServletRequest request) {
        try {
            projectRepository.save(project);
            return ResponseEntity.ok().body("Project updated successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Project could not be updated");
        }
    }

    @Override
    public ResponseEntity deleteProject(Long id, Principal principal, HttpServletRequest request) {
        try {
            projectRepository.deleteById(id);
            return ResponseEntity.ok().body("Project deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Project could not be deleted");
        }
    }

    @Override
    public ResponseEntity getProject(Long id) {
        try {
            return ResponseEntity.ok().body(projectRepository.findById(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Project could not be found");
        }
    }

}
