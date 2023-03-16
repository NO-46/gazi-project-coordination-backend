package com.example.authservice.repository;

import com.example.authservice.model.ERole;
import com.example.authservice.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);

    @Query(value = "SELECT name FROM role WHERE id = ?1", nativeQuery = true)
    String getRoleNameById(Long id);
}
