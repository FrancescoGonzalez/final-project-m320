package org.gonzalez.finalprojectm320.model;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ReservationTest {

    @Test
    void testException() {
        assertThrows(IllegalArgumentException.class, () -> new Reservation(1, 1, 1, 1, LocalDate.of(2024, 1, 2), LocalDate.of(2024, 1, 1)));
    }

    @Test
    void testReservedDays() {
        Reservation reservation = new Reservation(1, 1, 1, 1, LocalDate.of(2024, 1, 1), LocalDate.of(2024, 2, 29));
        assertEquals(31 + 29, reservation.reservedDays());

        reservation = new Reservation(1, 1, 1, 1, LocalDate.of(2024, 1, 1), LocalDate.of(2024, 1, 13));
        assertEquals(13, reservation.reservedDays());
    }

}