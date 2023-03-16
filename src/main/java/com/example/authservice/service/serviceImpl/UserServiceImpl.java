package com.example.authservice.service.serviceImpl;

import com.example.authservice.repository.UserRepository;
import com.example.authservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public ResponseEntity getUser(Long id) {
        try {
            return ResponseEntity.ok().body(userRepository.findById(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("User could not be retrieved");        }

    }

    @Override
    public ResponseEntity getAllUsers() {
        try {
            return ResponseEntity.ok().body(userRepository.findAll());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Users could not be retrieved");
        }
    }

}
