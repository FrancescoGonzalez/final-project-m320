package org.gonzalez.finalprojectm320.service;

import org.gonzalez.finalprojectm320.model.Reservation;
import org.gonzalez.finalprojectm320.repository.interfaces.ReservationRepository;
import org.gonzalez.finalprojectm320.repository.interfaces.RoomRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class ReservationServiceTest {

    @Autowired
    private ReservationService service;

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private RoomRepository roomRepository;

    @Test
    void createReservation() {
        Reservation reservation = new Reservation(0, 1, 1, 1, LocalDate.of(2021, 1, 1), LocalDate.of(2021, 1, 2));
        boolean result = service.createReservation(reservation);
        assertEquals(true, result);
    }

    @Test
    void getReservations() {
        List<Reservation> reservations = service.getReservations();
        assertThat(reservations.size()).isGreaterThan(0);
    }

    @Test
    void getReservation() {
        Reservation r = service.getReservation(1);
        assertEquals(r.id(), 1);
    }

    @Test
    void updateReservation() {
        Reservation r = service.getReservation(1);
        service.updateReservation(1, new Reservation(r.id(), r.customerId(), r.bookableId(), 4, r.checkIn(), r.checkOut()));
        assertEquals(4, service.getReservation(1).numberOfPeople());
    }
}