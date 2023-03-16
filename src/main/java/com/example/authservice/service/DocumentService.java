package com.example.authservice.service;

import com.example.authservice.model.Apply;
import com.example.authservice.model.Document;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

public interface DocumentService {

    ResponseEntity addDocument(Document document, Principal principal, HttpServletRequest request);

    ResponseEntity deleteDocument(Long id, Principal principal, HttpServletRequest request);

    ResponseEntity getDocument(Long id);

    Page<Document> findAll(Pageable pageable);



}
