package org.gonzalez.finalprojectm320.service;

import org.gonzalez.finalprojectm320.model.Customer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class CustomerServiceTest {

    @Autowired
    private CustomerService service;

    @Test
    void createCustomer() {
        Customer customer = new Customer(0, "Etienne", "Summermatter", LocalDate.of(2000, 1, 1), "ch");
        boolean result = service.createCustomer(customer);
        assertEquals(true, result);
    }

    @Test
    void getCustomers() {
        List<Customer> result = service.getCustomers();
        assertThat(result.size()).isGreaterThan(0);
    }

    @Test
    void getCustomer() {
        Customer result = service.getCustomer(1);
        assertEquals(1, result.id());
    }
}