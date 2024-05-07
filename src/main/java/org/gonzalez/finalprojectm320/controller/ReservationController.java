package org.gonzalez.finalprojectm320.controller;

import java.util.List;
import org.gonzalez.finalprojectm320.model.Reservation;
import org.gonzalez.finalprojectm320.usecase.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
    double getTotalPrice(@PathVariable int id) {
        return service.calculateTotalPrice(id);
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
