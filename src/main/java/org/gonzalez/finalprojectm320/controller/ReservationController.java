package org.gonzalez.finalprojectm320.controller;

import org.gonzalez.finalprojectm320.model.Reservation;
import org.gonzalez.finalprojectm320.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReservationController {

    @Autowired
    private ReservationService service;

    @PostMapping("/reservation")
    boolean createReservation(@RequestBody Reservation r) {
        return service.createReservation(r);
    }

    @GetMapping("/reservation")
    List<Reservation> getReservations() {
        return service.getReservations();
    }

    @GetMapping("/reservation/{id}")
    Reservation getReservation(@PathVariable int id) {
        return service.getReservation(id);
    }

    @GetMapping("/reservation/{id}/price")
    double getReservationPrice(@PathVariable int id) {
        return service.getReservation(id).calculateTotalPrice();
    }

    @PutMapping("/reservation/{id}")
    boolean updateReservation(@PathVariable int id,  @RequestBody Reservation newReservation) {
        return service.updateReservation(id, newReservation);
    }

    @DeleteMapping("/reservation/{id}")
    boolean deleteReservation(@PathVariable int id) {
        return service.deleteReservation(id);
    }
}
