package org.gonzalez.finalprojectm320.service;

import org.gonzalez.finalprojectm320.model.Reservation;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ReservationServiceTest {

    @Autowired
    private ReservationService service;

    @Test
    void getReservations() {
        List<Reservation> reservations = service.getReservations();
        assertThat(reservations.size()).isGreaterThan(0);
    }

    @Test
    void getReservation() {
        Reservation r = service.getReservation(1);
        assertEquals(1, r.id());
    }

    @Test
    void updateReservation() {
        Reservation r = service.getReservation(1);
        service.updateReservation(1, new Reservation(r.id(), r.customerId(), r.bookableId(), 4, r.checkIn(), r.checkOut()));
        assertEquals(4, service.getReservation(1).numberOfPeople());
    }
}