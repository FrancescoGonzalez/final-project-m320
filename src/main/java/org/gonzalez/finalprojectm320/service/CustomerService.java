package org.gonzalez.finalprojectm320.service;

import java.util.List;
import org.gonzalez.finalprojectm320.model.Customer;
import org.gonzalez.finalprojectm320.model.Reservation;
import org.gonzalez.finalprojectm320.model.Room;
import org.gonzalez.finalprojectm320.repository.RepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    private RepositoryInterface repository;

    public boolean createCustomer(Customer c) {
        return repository.createCustomer(c);
    }

    public List<Customer> getCustomers() {
        return repository.getCustomers();
    }
}
