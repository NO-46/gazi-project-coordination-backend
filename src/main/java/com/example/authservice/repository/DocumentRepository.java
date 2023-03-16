package com.example.authservice.repository;

import com.example.authservice.model.Document;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Repository
public interface DocumentRepository extends JpaRepository<Document, Long> {


    void deleteById(Long id);

   Document getById(Long id);

    List<Document> findAll();
}
