package org.gonzalez.finalprojectm320.service;

import org.gonzalez.finalprojectm320.model.Customer;
import org.gonzalez.finalprojectm320.model.Reservation;
import org.gonzalez.finalprojectm320.model.Room;
import org.gonzalez.finalprojectm320.repository.RepositoryInterface;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ReservationServiceTest {

    @Autowired
    private RepositoryInterface repository;

    @Autowired
    private ReservationService service;

    @Test
    void createCustomer() {
        Mockito.when(repository.createCustomer(Mockito.any())).thenReturn(true);
        assertTrue(service.createCustomer(new Customer("1234", "name", "surname", 2024, "us")));
    }

    @Test
    void getCustomers() {
        List<Customer> result = new ArrayList<>();
        result.add(new Customer("1234", "name", "surname", 2024, "us"));
        result.add(new Customer("5678", "name1", "surname1", 2023, "ch"));
        Mockito.when(repository.getCustomers()).thenReturn(result);
        assertEquals(service.getCustomers(), result);
    }

    @Test
    void createRoom() {
        Room room = new Room(101, 2, 50.0);
        Mockito.when(repository.createRoom(Mockito.any())).thenReturn(true);
        assertTrue(service.createRoom(room));
    }

    @Test
    void createReservation() {
        Reservation reservation = new Reservation(1, "JohnDoe", 2, 101, "2022-01-01", "2022-01-07");
        Mockito.when(repository.createReservation(Mockito.any())).thenReturn(true);
        assertTrue(service.createReservation(reservation));
    }

    @Test
    void getReservations() {
        List<Reservation> result = new ArrayList<>();
        result.add(new Reservation(1, "JohnDoe", 2, 101, "2022-01-01", "2022-01-07"));
        Mockito.when(repository.getReservations()).thenReturn(result);
        assertEquals(service.getReservations(), result);
    }

    @Test
    void getReservation() {
        Reservation reservation = new Reservation(1, "JohnDoe", 2, 101, "2022-01-01", "2022-01-07");
        Mockito.when(repository.getReservation(1)).thenReturn(reservation);
        assertEquals(service.getReservation(1), reservation);
    }
}