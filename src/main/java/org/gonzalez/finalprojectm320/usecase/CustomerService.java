package org.gonzalez.finalprojectm320.usecase;

import java.util.List;
import org.gonzalez.finalprojectm320.model.Customer;
import org.gonzalez.finalprojectm320.repository.interfaces.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    private final CustomerRepository repository;

    public CustomerService(CustomerRepository customerRepository) {
        this.repository = customerRepository;
    }

    public boolean createCustomer(Customer c) {
        return repository.createCustomer(c);
    }

    public List<Customer> getCustomers() {
        return repository.getCustomers();
    }
}
