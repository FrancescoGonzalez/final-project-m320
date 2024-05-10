package org.gonzalez.finalprojectm320.controller;

import java.util.List;
import org.gonzalez.finalprojectm320.model.Customer;
import org.gonzalez.finalprojectm320.usecase.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class CustomerController {

    @Autowired
    private CustomerService service;

    @PostMapping("/customer")
    boolean createCustomer(@RequestBody Customer c) {
        return service.createCustomer(c);
    }

    @GetMapping("/customer")
    List<Customer> getCustomers() {
        return service.getCustomers();
    }

    @GetMapping("/customer/{id}")
    Customer getCustomer(@PathVariable int id) {
        return service.getCustomer(id);
    }
}
