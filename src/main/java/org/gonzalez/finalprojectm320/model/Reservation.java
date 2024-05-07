package org.gonzalez.finalprojectm320.model;

import java.time.LocalDate;
public class Reservation {

    private final int id;
    private final int customerId;
    private final int bookableId;
    private final int numberOfPeople;
    private final LocalDate checkIn;
    private final LocalDate checkOut;

    public Reservation(int id, int customerId, int bookableId, int numberOfPeople, LocalDate checkIn, LocalDate checkOut) {

        if (checkIn.isAfter(checkOut)) {
            throw new IllegalArgumentException("Check-in date must be before check-out date");
        }

        this.id = id;
        this.customerId = customerId;
        this.bookableId = bookableId;
        this.numberOfPeople = numberOfPeople;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public int reservedDays(){
        return checkIn.until(checkOut).getDays();
    }

    public int getId() {
        return id;
    }

    public int getCustomerId() {
        return customerId;
    }

    public int getBookableId() {
        return bookableId;
    }

    public int getNumberOfPeople() {
        return numberOfPeople;
    }

    public LocalDate getCheckIn() {
        return checkIn;
    }

    public LocalDate getCheckOut() {
        return checkOut;
    }
}
