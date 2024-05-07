package org.gonzalez.finalprojectm320.model;

import java.time.LocalDate;

public record Reservation(
    int id,
    int customerId,
    int bookableId,
    int numberOfPeople,
    LocalDate checkIn,
    LocalDate checkOut
) {
    public Reservation {
        if (checkIn.isAfter(checkOut)) {
            throw new IllegalArgumentException("Check-in date must be before check-out date");
        }
    }

    public int reservedDays(){
        return checkIn.until(checkOut).getDays();
    }
}