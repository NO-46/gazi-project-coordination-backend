package com.example.authservice.repository;

import com.example.authservice.model.Apply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ApplyRepository extends JpaRepository<Apply, UUID> {

    Apply findById(Long Id);

    void deleteById(Long id);

    List<Apply> findAll();



}
