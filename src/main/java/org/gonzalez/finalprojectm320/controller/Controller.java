package org.gonzalez.finalprojectm320.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {

    @PutMapping("/createReservation")
    void createReservation(@RequestBody Reservation reservation) {
        repository.createReservation(reservation);
    }

    @PutMapping("/update/{id}")
    void updateReservation(@PathVariable String id, @RequestBody Reservation newReservation) {
        updateReservation(id, newReservation);
    }

    @GetMapping("/reservation/{id}")
    Reservation getReservation(@PathVariable int id) {
        return repository.getReservation(id);
    }

    @GetMapping("/customer/{id}")
    Customer getCustomer(@PathVariable String id) {
        return new Customer(0, "Fabio", "Giger", "30.3.2007", "Switzerland");
    }
}
