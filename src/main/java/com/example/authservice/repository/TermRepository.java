package com.example.authservice.repository;

import com.example.authservice.model.Term;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;


@Repository
public interface TermRepository extends JpaRepository<Term, UUID> {
}
