package org.gonzalez.finalprojectm320.repository;

import java.util.List;
import org.gonzalez.finalprojectm320.model.Customer;
import org.gonzalez.finalprojectm320.model.Reservation;
import org.gonzalez.finalprojectm320.model.Room;

public interface CustomerRepository {
    boolean createCustomer(Customer c);
    List<Customer> getCustomers();
}
