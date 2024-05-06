package org.gonzalez.finalprojectm320.model;

public record Room(
    int id,
    int number,
    String type,
    int maxPeople,
    double priceForPerson
) {}