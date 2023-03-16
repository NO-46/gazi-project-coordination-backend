package com.example.authservice.service;

import com.example.authservice.model.Deadline;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface DeadlineService {

    void deleteDeadlineById(Long id);

    List<Deadline> findAll();

    ResponseEntity addDeadline(Deadline deadline);
}
