package com.example.authservice.controller;

import com.example.authservice.service.TermService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;

@RestController
@Transactional
@RequestMapping("/api/v1/term-management")
public class TermController {

    private TermService termService;

    @Autowired
    public TermController(TermService termService) {
        this.termService = termService;
    }
}
