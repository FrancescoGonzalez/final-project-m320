package org.gonzalez.finalprojectm320.model;

import java.time.LocalDate;
import org.springframework.stereotype.Component;

@Component
public class Reservation {


    private int id;
    private int customerId;
    private int bookableId;
    private int numberOfPeople;
    private LocalDate checkIn;
    private LocalDate checkOut;

    /*
    *
    * Basic constructor for Reservation. It should be replaced with a constructor that takes in all the fields of the class. (.createReservation())
    *
    * */
    public Reservation() {
        this.id = 0;
        this.customerId = 0;
        this.bookableId = 0;
        this.numberOfPeople = 0;
        this.checkIn = LocalDate.now();
        this.checkOut = LocalDate.now();
    }

    public Reservation createReservation(int id, int customerId, int bookableId, int numberOfPeople, LocalDate checkIn, LocalDate checkOut) {

        if (checkIn.isAfter(checkOut)) {
            throw new IllegalArgumentException("Check-in date must be before check-out date");
        }

        this.id = id;
        this.customerId = customerId;
        this.bookableId = bookableId;
        this.numberOfPeople = numberOfPeople;
        this.checkIn = checkIn;
        this.checkOut = checkOut;

        return this;
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

    public int reservedDays(){
        return checkIn.until(checkOut).getDays();
    }
}
