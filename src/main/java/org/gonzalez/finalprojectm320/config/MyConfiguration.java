package org.gonzalez.finalprojectm320.config;

import org.gonzalez.finalprojectm320.repository.CustomerRepository;
import org.gonzalez.finalprojectm320.repository.JdbcCustomerRepository;
import org.gonzalez.finalprojectm320.repository.ReservationRepository;
import org.gonzalez.finalprojectm320.service.CustomerService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class MyConfiguration {

    @Bean
    public CustomerRepository customerRepository(JdbcTemplate jdbcTemplate) {
        return new JdbcCustomerRepository(jdbcTemplate);
    }

    @Bean
    public CustomerService customerService(CustomerRepository customerRepository) {
        return new CustomerService(customerRepository);
    }
}
