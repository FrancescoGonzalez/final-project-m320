package org.gonzalez.finalprojectm320.model;

import java.time.LocalDate;
import org.gonzalez.finalprojectm320.repository.JdbcRoomRepository;
import org.gonzalez.finalprojectm320.service.RoomService;
import org.springframework.jdbc.core.JdbcTemplate;

public record Reservation(
    int id,
    int customerId,
    int roomId,
    int numberOfPeople,
    LocalDate checkIn,
    LocalDate checkOut
) {
    public Reservation {
        if (checkIn.isAfter(checkOut)) {
            throw new IllegalArgumentException("Check-in date must be before check-out date");
        }
    }

    public Double calculateTotalPrice() {
        return new RoomService(new JdbcRoomRepository(new JdbcTemplate())).getRoom(this.roomId).priceForPerson() * (double) numberOfPeople * (double) checkIn.until(checkOut).getDays();
    }
}
