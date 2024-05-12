package org.gonzalez.finalprojectm320.controller;

import java.util.List;
import org.gonzalez.finalprojectm320.model.Reservation;
import org.gonzalez.finalprojectm320.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
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

    @GetMapping("/reservation/availability")
    boolean checkAvailability(@RequestBody Reservation r) {
        return service.checkAvailability(r.bookableId(), java.sql.Date.valueOf(r.checkIn()), java.sql.Date.valueOf(r.checkOut()));
    }


}
