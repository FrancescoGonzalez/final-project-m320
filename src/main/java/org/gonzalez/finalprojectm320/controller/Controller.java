package org.gonzalez.finalprojectm320.controller;

import org.gonzalez.finalprojectm320.model.Customer;
import org.gonzalez.finalprojectm320.model.Reservation;
import org.gonzalez.finalprojectm320.model.Room;
import org.gonzalez.finalprojectm320.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller {

    @Autowired
    private MyService service;

    @PutMapping("/create-reservation")
    void createReservation(@RequestBody Reservation r) {
        service.createReservation(r);
    }

    @PutMapping("/create-customer")
    void createCustomer(@RequestBody Customer c) {
        service.createCustomer(c);
    }

    @PutMapping("/create-room")
    void createRoom(@RequestBody Room r) {
        service.createRoom(r);
    }

    @GetMapping("/get-customers")
    List<Customer> getCustomers() {
        return service.getCustomers();
    }

    @GetMapping("/get-reservations")
    List<Reservation> getReservations() {
        return service.getReservations();
    }

    @GetMapping("/get-singular-reservation/{id}")
    Reservation getReservation(@PathVariable int id) {
        return service.getReservation(id);
    }

    @PutMapping("/update/{id}")
    void updateReservation(@PathVariable int id,  @RequestBody Reservation newReservation) {
        service.updateReservation(id, newReservation);
    }
}
