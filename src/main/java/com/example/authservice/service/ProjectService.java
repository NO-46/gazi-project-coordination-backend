package com.example.authservice.service;

import com.example.authservice.model.Project;
import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

public interface ProjectService {

    ResponseEntity addProject(Project project, Principal principal, HttpServletRequest request);

    ResponseEntity updateProject(Project project,Principal principal, HttpServletRequest request);

    ResponseEntity deleteProject(Long id, Principal principal, HttpServletRequest request);

    ResponseEntity getProject(Long id);


}
