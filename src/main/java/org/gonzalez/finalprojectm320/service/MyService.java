package org.gonzalez.finalprojectm320.service;

import org.gonzalez.finalprojectm320.model.Customer;
import org.gonzalez.finalprojectm320.repository.MongoDBRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyService {

    @Autowired
    private MongoDBRepository repository;

    public void createCustomer(Customer c) {
        repository.createCustomer(c);
    }
}
