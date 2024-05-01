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
    boolean createReservation(@RequestBody Reservation r) {
        return service.createReservation(r);
    }

    @PutMapping("/create-customer")
    boolean createCustomer(@RequestBody Customer c) {
        return service.createCustomer(c);
    }

    @PutMapping("/create-room")
    boolean createRoom(@RequestBody Room r) {
        return service.createRoom(r);
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
    boolean updateReservation(@PathVariable int id,  @RequestBody Reservation newReservation) {
        return service.updateReservation(id, newReservation);
    }
}
