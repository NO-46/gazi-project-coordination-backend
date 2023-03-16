package com.example.authservice.service.serviceImpl;

import com.example.authservice.model.Apply;
import com.example.authservice.repository.ApplyRepository;
import com.example.authservice.repository.RoleRepository;
import com.example.authservice.repository.UserRepository;
import com.example.authservice.service.ApplyService;
import org.springframework.data.domain.PageRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.time.LocalDateTime;

@Service
public class ApplyServiceImpl implements ApplyService {

    private ApplyRepository applyRepository;

    private UserRepository userRepository;

    private RoleRepository roleRepository;

    @Autowired
    public ApplyServiceImpl(ApplyRepository applyRepository) {
        this.applyRepository = applyRepository;
    }

    @Override
    public ResponseEntity addApply(Apply apply, Principal principal, HttpServletRequest request) {
        try {
            // if (deadlineRepository.getDeadlineById(?).getDeadline().isBefore(LocalDateTime.now())
            applyRepository.save(apply);
            return ResponseEntity.ok().body("Apply added successfully");

        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Apply could not be added");
        }
    }

    @Override
    public ResponseEntity deleteApply(Long id, Principal principal, HttpServletRequest request) {
        try {
            applyRepository.deleteById(id);
            return ResponseEntity.ok().body("Apply deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Apply could not be deleted");
        }
    }

    @Override
    public Page<Apply> findAll(Pageable pageable) {
        Pageable firstPageWithTwoElements = PageRequest.of(0, 10);
        return applyRepository.findAll(firstPageWithTwoElements);
    }

    @Override
    public ResponseEntity updateApply(Apply apply, Principal principal, HttpServletRequest request) {
        return null;
    }


}
