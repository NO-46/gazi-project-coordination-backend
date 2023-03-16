package com.example.authservice.controller;

import com.example.authservice.model.Apply;
import com.example.authservice.service.ApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import java.security.Principal;


@RestController
@Transactional
@RequestMapping("/api/v1/apply-management")
public class ApplyController {

    private ApplyService applyService;

    @Autowired
    public ApplyController(ApplyService applyService) {
        this.applyService = applyService;
    }

    @PostMapping("/apply")
    public ResponseEntity add(@RequestBody Apply apply, Principal principal, HttpServletRequest request) {

        return ResponseEntity.ok().body(this.applyService.addApply(apply, principal, request));
    }

   @DeleteMapping("/apply/{id}")
    public ResponseEntity delete(@PathVariable("id") Long id, Principal principal, HttpServletRequest request) {
        return ResponseEntity.ok().body(this.applyService.deleteApply(id, principal, request));
    }

    @GetMapping("/apply/all")
    public ResponseEntity<Page<Apply>> getAll(Pageable pageable) {
        return ResponseEntity.ok().body(this.applyService.findAll(pageable));
    }



}
