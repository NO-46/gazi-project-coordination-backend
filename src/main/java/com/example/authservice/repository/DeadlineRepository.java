package com.example.authservice.repository;

import com.example.authservice.model.Deadline;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DeadlineRepository extends JpaRepository<Deadline, Long> {
    Deadline getDeadlineById(Long id);

    List<Deadline> findAll();


}
