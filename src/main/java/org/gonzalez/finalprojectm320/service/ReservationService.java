package org.gonzalez.finalprojectm320.service;

import java.util.List;
import org.gonzalez.finalprojectm320.model.Reservation;
import org.gonzalez.finalprojectm320.repository.interfaces.ReservationRepository;
import org.springframework.stereotype.Service;

@Service
public class ReservationService {

    private final ReservationRepository repository;

    public ReservationService(ReservationRepository reservationRepository) {
        this.repository = reservationRepository;
    }

    public boolean createReservation(org.gonzalez.finalprojectm320.model.Reservation r) {
        return repository.createReservation(r);
    }

    public List<Reservation> getReservations() {
        return repository.getReservations();
    }

    public org.gonzalez.finalprojectm320.model.Reservation getReservation(int id) {
        return repository.getReservation(id);
    }

    public boolean updateReservation(int id, org.gonzalez.finalprojectm320.model.Reservation newReservation) {
        return repository.updateReservation(id, newReservation);
    }

    public boolean deleteReservation(int id) {
        return repository.deleteReservation(id);
    }
}
