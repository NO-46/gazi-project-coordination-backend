package com.example.authservice.service.serviceImpl;

import com.example.authservice.model.*;
import com.example.authservice.repository.DocumentRepository;
import com.example.authservice.repository.RoleRepository;
import com.example.authservice.repository.UserRepository;
import com.example.authservice.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.UUID;

@Service
public class DocumentServiceImpl implements DocumentService {

    private DocumentRepository documentRepository;

    private UserRepository userRepository;

    private RoleRepository roleRepository;

    @Autowired
    public DocumentServiceImpl(DocumentRepository documentRepository, UserRepository userRepository, RoleRepository roleRepository) {
        this.documentRepository = documentRepository;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public ResponseEntity addDocument(Document document, Principal principal, HttpServletRequest request) {

        try {
            document.setUser(userRepository.getById(userRepository.getUserIdByUsername(principal.getName())));
            if (roleRepository.getRoleNameById(userRepository.getRoleIdByUsername(principal.getName())).equals("ROLE_STUDENT")) {
                document.setGroup(userRepository.getGroupIdByUsername(principal.getName()));
            }
            documentRepository.save(document);

        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Document could not be added");
        }
        return ResponseEntity.ok().body("Document added successfully");
    }


    @Override
    public ResponseEntity deleteDocument(Long id, Principal principal, HttpServletRequest request) {

        try {
            if (userRepository.getUserIdByUsername(principal.getName()) == documentRepository.getById(id).getUser().getId() || roleRepository.getRoleNameById(userRepository.getRoleIdByUsername(principal.getName())).equals("ROLE_ADMIN")) {
                documentRepository.deleteById(id);
                return ResponseEntity.ok().body("Document deleted successfully");
            }

        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Document could not be deleted");
        }
        return ResponseEntity.badRequest().body("Document could not be deleted");
    }



    @Override
    public ResponseEntity getDocument(Long id) {
        try {
            return ResponseEntity.ok().body(documentRepository.getById(id));

        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Document could not be found");
        }
    }

    @Override
    public Page<Document> findAll(Pageable pageable) {
        Pageable firstPageWithTwoElements = PageRequest.of(0, 10);
        return documentRepository.findAll(firstPageWithTwoElements);
    }

}
