package org.gonzalez.finalprojectm320.repository.interfaces;

import java.util.List;
import org.gonzalez.finalprojectm320.model.Customer;

public interface CustomerRepository {
    boolean createCustomer(Customer c);
    List<Customer> getCustomers();
    Customer getCustomer(int id);
}
