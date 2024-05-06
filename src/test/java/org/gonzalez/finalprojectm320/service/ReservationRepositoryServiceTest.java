package org.gonzalez.finalprojectm320.service;

import org.gonzalez.finalprojectm320.repository.ReservationRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ReservationRepositoryServiceTest {

    /*@Autowired
    private ReservationRepository repository;

    @Autowired
    private ReservationService service;


    @Test
    void createReservation() {
        org.gonzalez.finalprojectm320.model.Reservation reservation = new org.gonzalez.finalprojectm320.model.Reservation(1, "JohnDoe", 2, 101, "2022-01-01", "2022-01-07");
        Mockito.when(repository.createReservation(Mockito.any())).thenReturn(true);
        assertTrue(service.createReservation(reservation));
    }

    @Test
    void getReservations() {
        List<org.gonzalez.finalprojectm320.model.Reservation> result = new ArrayList<>();
        result.add(new org.gonzalez.finalprojectm320.model.Reservation(1, "JohnDoe", 2, 101, "2022-01-01", "2022-01-07"));
        Mockito.when(repository.getReservations()).thenReturn(result);
        assertEquals(service.getReservations(), result);
    }

    @Test
    void getReservation() {
        org.gonzalez.finalprojectm320.model.Reservation reservation = new org.gonzalez.finalprojectm320.model.Reservation(1, "JohnDoe", 2, 101, "2022-01-01", "2022-01-07");
        Mockito.when(repository.getReservation(1)).thenReturn(reservation);
        assertEquals(service.getReservation(1), reservation);
    }*/
}