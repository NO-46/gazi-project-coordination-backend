package com.example.authservice.controller;

import com.example.authservice.model.Apply;
import com.example.authservice.model.Document;
import com.example.authservice.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import java.security.Principal;

@RestController
@Transactional
@RequestMapping("/api/v1/document-management")
public class DocumentController {
    private DocumentService documentService;

    @Autowired
    public DocumentController(DocumentService documentService) {
        this.documentService = documentService;
    }

    @PostMapping("/document")
    public ResponseEntity add(@RequestBody Document document, Principal principal, HttpServletRequest request) {
        return ResponseEntity.ok().body(this.documentService.addDocument(document, principal, request));
    }

    @DeleteMapping("/document/{id}")
    public ResponseEntity delete(@PathVariable("id") Long id, Principal principal, HttpServletRequest request) {
        return ResponseEntity.ok().body(this.documentService.deleteDocument(id, principal, request));
    }

    @GetMapping("/document/{id}")
    public ResponseEntity get(@PathVariable("id") Long id) {
        return ResponseEntity.ok().body(this.documentService.getDocument(id));
    }

    @GetMapping("/document/all")
    public ResponseEntity<Page<Document>> getAll(Pageable pageable) {
        return ResponseEntity.ok().body(this.documentService.findAll(pageable));
    }

}
