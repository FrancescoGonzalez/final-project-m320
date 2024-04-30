package org.gonzalez.finalprojectm320.model;

public class Room {
    private int number;
    private int maxPeople;
    private double priceForPerson;

    public Room(int number, int maxPeople, double priceForPerson) {
        this.number = number;
        this.maxPeople = maxPeople;
        this.priceForPerson = priceForPerson;
    }

    public int getNumber() {
        return number;
    }

    public int getMaxPeople() {
        return maxPeople;
    }

    public double getPriceForPerson() {
        return priceForPerson;
    }
}
