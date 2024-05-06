package org.gonzalez.finalprojectm320.controller;

import java.util.List;
import org.gonzalez.finalprojectm320.model.Customer;
import org.gonzalez.finalprojectm320.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

    @Autowired
    private ReservationService service;

    @PostMapping("/customer")
    boolean createCustomer(@RequestBody Customer c) {
        return service.createCustomer(c);
    }

    @GetMapping("/customers")
    List<Customer> getCustomers() {
        return service.getCustomers();
    }
}
