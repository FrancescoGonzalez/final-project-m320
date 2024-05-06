package org.gonzalez.finalprojectm320.config;

import org.gonzalez.finalprojectm320.repository.JdbcReservationRepository;
import org.gonzalez.finalprojectm320.repository.JdbcRoomRepository;
import org.gonzalez.finalprojectm320.repository.interfaces.CustomerRepository;
import org.gonzalez.finalprojectm320.repository.JdbcCustomerRepository;
import org.gonzalez.finalprojectm320.repository.interfaces.ReservationRepository;
import org.gonzalez.finalprojectm320.repository.interfaces.RoomRepository;
import org.gonzalez.finalprojectm320.service.CustomerService;
import org.gonzalez.finalprojectm320.service.ReservationService;
import org.gonzalez.finalprojectm320.service.RoomService;
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

    @Bean
    public RoomRepository roomRepository(JdbcTemplate jdbcTemplate) {
        return new JdbcRoomRepository(jdbcTemplate);
    }

    @Bean
    public RoomService roomService(RoomRepository roomRepository) {
        return new RoomService(roomRepository);
    }

    @Bean
    public ReservationRepository reservationRepository(JdbcTemplate jdbcTemplate) {
        return new JdbcReservationRepository(jdbcTemplate);
    }

    @Bean
    public ReservationService reservationService(ReservationRepository reservationRepository) {
        return new ReservationService(reservationRepository);
    }
}
