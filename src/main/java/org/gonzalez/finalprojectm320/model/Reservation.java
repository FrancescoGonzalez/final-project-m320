package org.gonzalez.finalprojectm320.model;

public class Reservation {
    private int id;
    private Customer customer;
    private int numberOfPeople;
    private Room room;
    private String beginDate;
    private String endDate;

    public Reservation(int id, Customer customer, int numberOfPeople, Room room, String beginDate, String endDate) {
        this.id = id;
        this.customer = customer;
        this.numberOfPeople = numberOfPeople;
        this.room = room;
        this.beginDate = beginDate;
        this.endDate = endDate;
    }

    public int getId() {
        return id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public int getNumberOfPeople() {
        return numberOfPeople;
    }

    public Room getRoom() {
        return room;
    }

    public String getBeginDate() {
        return beginDate;
    }

    public String getEndDate() {
        return endDate;
    }
}
