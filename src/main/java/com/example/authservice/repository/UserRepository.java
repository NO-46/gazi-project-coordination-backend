package com.example.authservice.repository;

import com.example.authservice.model.Group;
import com.example.authservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);

    Optional<User> findById(Long id);

    User getById(Long id);

    @Query(value = "SELECT id FROM users WHERE username = ?1", nativeQuery = true)
    Long getUserIdByUsername(String username);

    @Query(value = "SELECT role_id FROM users_to_roles INNER JOIN users ON users_to_roles.user_id = users.id WHERE users.username = ?1 ", nativeQuery = true)
    Long getRoleIdByUsername(String username);

    @Query(value = "SELECT group_id FROM users WHERE username = ?1 ", nativeQuery = true)
    Group getGroupIdByUsername(String username);

    @Query(value = "SELECT group_id FROM users where id = ?1 ", nativeQuery = true)
    User getGroupIdByUserId(Long id);



}
