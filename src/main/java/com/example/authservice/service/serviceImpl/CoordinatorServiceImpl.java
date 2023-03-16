package com.example.authservice.service.serviceImpl;

import com.example.authservice.repository.CoordinatorRepository;
import com.example.authservice.service.CoordinatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CoordinatorServiceImpl implements CoordinatorService {

    private CoordinatorRepository coordinatorRepository;

    @Autowired
    public CoordinatorServiceImpl(CoordinatorRepository coordinatorRepository) {
        this.coordinatorRepository = coordinatorRepository;
    }
}
