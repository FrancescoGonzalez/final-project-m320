package org.gonzalez.finalprojectm320.service;

import org.gonzalez.finalprojectm320.repository.JdbcRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyService {

    @Autowired
    private JdbcRepository repository;
}
