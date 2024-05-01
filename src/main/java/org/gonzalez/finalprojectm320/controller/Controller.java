package org.gonzalez.finalprojectm320.controller;

import org.gonzalez.finalprojectm320.model.Customer;
import org.gonzalez.finalprojectm320.model.Reservation;
import org.gonzalez.finalprojectm320.model.Room;
import org.gonzalez.finalprojectm320.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {

    @Autowired
    private MyService service;

    @PutMapping("/create-reservation")
    void createReservation(@RequestBody Reservation r) {

    }

    @PutMapping("/create-customer")
    void createCustomer(@RequestBody Customer c) {
        service.createCustomer(c);
    }

    @PutMapping("/update/{id}")
    void updateReservation(@RequestBody Reservation newReservation) {

    }

    @GetMapping("/reservation/{id}")
    Reservation getReservation(@PathVariable int id) {
        return new Reservation(1, new Customer("Fabio", "Giger", 2007, "CH"), 2, new Room(203, 3, 67.50), "2.3.2024", "4.3.2024");
    }
}
