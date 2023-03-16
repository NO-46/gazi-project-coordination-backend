package com.example.authservice.service;

import com.example.authservice.model.Apply;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.List;

public interface ApplyService {

    ResponseEntity addApply(Apply apply, Principal principal, HttpServletRequest request);

    ResponseEntity deleteApply(Long id, Principal principal, HttpServletRequest request);

    Page<Apply> findAll(Pageable pageable);

    ResponseEntity updateApply(Apply apply, Principal principal, HttpServletRequest request);




}
