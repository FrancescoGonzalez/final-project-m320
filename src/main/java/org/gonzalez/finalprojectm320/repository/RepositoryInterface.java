package org.gonzalez.finalprojectm320.repository;

import org.gonzalez.finalprojectm320.model.Customer;
import org.gonzalez.finalprojectm320.model.Reservation;
import org.gonzalez.finalprojectm320.model.Room;

import java.util.List;

public interface RepositoryInterface {
    boolean createCustomer(Customer c);
    boolean createRoom(Room r);
    boolean createReservation(Reservation r);

    List<Customer> getCustomers();
    List<Reservation> getReservations();

    Reservation getReservation(int id);

    boolean updateReservation(int id, Reservation newReservation);
}
