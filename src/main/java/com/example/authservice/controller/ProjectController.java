package com.example.authservice.controller;

import com.example.authservice.model.Document;
import com.example.authservice.model.Project;
import com.example.authservice.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import java.security.Principal;

@RestController
@Transactional
@RequestMapping("/api/v1/project-management")
public class ProjectController {
    private ProjectService projectService;

    @Autowired
    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @PostMapping("/project")
    public ResponseEntity add(@RequestBody Project project, Principal principal, HttpServletRequest request) {
        return ResponseEntity.ok().body(this.projectService.addProject(project, principal, request));
    }

    @PutMapping("/project/update")
    public ResponseEntity update(@RequestBody Project project, Principal principal, HttpServletRequest request) {
        return ResponseEntity.ok().body(this.projectService.updateProject(project, principal, request));
    }

    @DeleteMapping("/project/{id}")
    public ResponseEntity delete(@PathVariable("id") Long id, Principal principal, HttpServletRequest request) {
        return ResponseEntity.ok().body(this.projectService.deleteProject(id, principal, request));
    }

    @GetMapping("/project/{id}")
    public ResponseEntity get(@PathVariable("id") Long id) {
        return ResponseEntity.ok().body(this.projectService.getProject(id));
    }

}
