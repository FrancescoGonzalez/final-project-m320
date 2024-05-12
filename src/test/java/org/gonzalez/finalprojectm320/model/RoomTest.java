package org.gonzalez.finalprojectm320.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoomTest {

    @Test
    void calculateTotalPrice() {
        Room room = new Room(1, 101, "Single", 1, 100.0);
        assertEquals(100.0, room.calculateTotalPrice(1, 1));
        assertEquals(400.0, room.calculateTotalPrice(2, 2));
        assertEquals(600.0, room.calculateTotalPrice(3, 2));
    }

    @Test
    void getPriceForPerson() {
        Room room = new Room(1, 101, "Single", 1, 100.0);
        assertEquals(100.0, room.getPriceForPerson());
    }

    @Test
    void getMaxPeople() {
        Room room = new Room(1, 101, "Single", 1, 100.0);
        assertEquals(1, room.getMaxPeople());
    }

}