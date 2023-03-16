package com.example.authservice.service.serviceImpl;

import com.example.authservice.model.Deadline;
import com.example.authservice.repository.DeadlineRepository;
import com.example.authservice.service.DeadlineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class DeadlineSeviceImpl implements DeadlineService {



    private DeadlineRepository deadlineRepository;

    public DeadlineSeviceImpl(DeadlineRepository deadlineRepository) {
        this.deadlineRepository = deadlineRepository;
    }


    @Override
    public void deleteDeadlineById(Long id) {

    }

    @Override
    public List<Deadline> findAll() {
        return null;
    }

    @Override
    public ResponseEntity addDeadline(Deadline deadline) {
        try {
            deadlineRepository.save(deadline);
            return ResponseEntity.ok().body("Deadline added successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Deadline could not be added");
        }
    }
}
