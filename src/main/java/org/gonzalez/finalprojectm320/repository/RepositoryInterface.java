package org.gonzalez.finalprojectm320.repository;

import org.gonzalez.finalprojectm320.model.Customer;
import org.gonzalez.finalprojectm320.model.Reservation;
import org.gonzalez.finalprojectm320.model.Room;

import java.util.List;

public interface RepositoryInterface {
    void createCustomer(Customer c);
    void createRoom(Room r);
    void createReservation(Reservation r);

    List<Customer> getCustomers();
    List<Reservation> getReservations();

    Reservation getReservation(int id);

    void updateReservation(int id, Reservation newReservation);
}
