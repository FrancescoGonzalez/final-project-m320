package org.gonzalez.finalprojectm320.repository.interfaces;

import java.util.List;

public interface ReservationRepository {
    boolean createReservation(org.gonzalez.finalprojectm320.model.Reservation r);
    List<org.gonzalez.finalprojectm320.model.Reservation> getReservations();

    org.gonzalez.finalprojectm320.model.Reservation getReservation(int id);

    boolean updateReservation(int id, org.gonzalez.finalprojectm320.model.Reservation newReservation);

    boolean deleteReservation(int id);

    boolean checkAvailability(int bookableId, java.sql.Date checkIn, java.sql.Date checkOut);


}
