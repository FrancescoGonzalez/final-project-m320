package org.gonzalez.finalprojectm320.model;

public record Reservation(
    int id,
    int customerId,
    int roomId,
    int numberOfPeople,
    String checkIn,
    String checkOut
) {}
