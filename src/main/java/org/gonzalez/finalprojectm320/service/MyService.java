package org.gonzalez.finalprojectm320.service;

import org.gonzalez.finalprojectm320.model.Customer;
import org.gonzalez.finalprojectm320.model.Reservation;
import org.gonzalez.finalprojectm320.model.Room;
import org.gonzalez.finalprojectm320.repository.RepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyService {

    @Autowired
    private RepositoryInterface repository;

    public boolean createCustomer(Customer c) {
        return repository.createCustomer(c);
    }

    public List<Customer> getCustomers() {
        return repository.getCustomers();
    }


    public boolean createRoom(Room r) {
        return repository.createRoom(r);
    }

    public boolean createReservation(Reservation r) {
        return repository.createReservation(r);
    }


    public List<Reservation> getReservations() {
        return repository.getReservations();
    }

    public Reservation getReservation(int id) {
        return repository.getReservation(id);
    }

    public boolean updateReservation(int id, Reservation newReservation) {
        return repository.updateReservation(id, newReservation);
    }
}
