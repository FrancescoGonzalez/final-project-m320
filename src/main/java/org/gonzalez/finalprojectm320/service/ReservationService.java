package org.gonzalez.finalprojectm320.service;

import org.gonzalez.finalprojectm320.model.Customer;
import org.gonzalez.finalprojectm320.model.Reservation;
import org.gonzalez.finalprojectm320.model.Room;
import org.gonzalez.finalprojectm320.repository.RepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {

    @Autowired
    private RepositoryInterface repository;

    public boolean createReservation(Reservation r) {
        return repository.createReservation(r);
    }

    public List<Reservation> getReservations() {
        return repository.getReservations();
    }

    public Reservation getReservation(int id) {
        return repository.getReservation(id);
    }

    public boolean updateReservation(int id, Reservation newReservation) {
        return repository.updateReservation(id, newReservation);
    }
}
