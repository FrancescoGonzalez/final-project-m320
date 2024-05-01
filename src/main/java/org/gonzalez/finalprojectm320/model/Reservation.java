package org.gonzalez.finalprojectm320.model;

public class Reservation {
    private int reservationNumber;
    private String customerId;
    private int numberOfPeople;
    private int roomNumber;
    private String beginDate;
    private String endDate;

    public Reservation(int reservationNumber, String customerId, int numberOfPeople, int roomNumber, String beginDate, String endDate) {
        this.reservationNumber = reservationNumber;
        this.customerId = customerId;
        this.numberOfPeople = numberOfPeople;
        this.roomNumber = roomNumber;
        this.beginDate = beginDate;
        this.endDate = endDate;
    }

    public int getReservationNumber() {
        return reservationNumber;
    }

    public String getCustomerId() {
        return customerId;
    }

    public int getNumberOfPeople() {
        return numberOfPeople;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public String getBeginDate() {
        return beginDate;
    }

    public String getEndDate() {
        return endDate;
    }
}
