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

    public void createCustomer(Customer c) {
        repository.createCustomer(c);
    }

    public List<Customer> getCustomers() {
        return repository.getCustomers();
    }


    public void createRoom(Room r) {
        repository.createRoom(r);
    }

    public void createReservation(Reservation r) {
        repository.createReservation(r);
    }


    public List<Reservation> getReservations() {
        return repository.getReservations();
    }

    public Reservation getReservation(int id) {
        return repository.getReservation(id);
    }

    public void updateReservation(int id, Reservation newReservation) {
        repository.updateReservation(id, newReservation);
    }
}
