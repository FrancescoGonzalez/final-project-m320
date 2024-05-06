package org.gonzalez.finalprojectm320.repository;

import org.gonzalez.finalprojectm320.model.Customer;
import org.gonzalez.finalprojectm320.model.Room;

import java.util.List;

public interface ReservationRepository {
    boolean createReservation(org.gonzalez.finalprojectm320.model.Reservation r);
    List<org.gonzalez.finalprojectm320.model.Reservation> getReservations();

    org.gonzalez.finalprojectm320.model.Reservation getReservation(int id);

    boolean updateReservation(int id, org.gonzalez.finalprojectm320.model.Reservation newReservation);
}
