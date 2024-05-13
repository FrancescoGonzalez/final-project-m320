package org.gonzalez.finalprojectm320.service;

import org.gonzalez.finalprojectm320.model.Customer;
import org.gonzalez.finalprojectm320.model.Room;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RoomServiceTest {

    @Autowired
    private RoomService service;

    @Test
    void createRoom() {
        Room r = new Room(0, 1, "SINGLE", 1, 12);
        boolean result = service.createRoom(r);
        assertEquals(true, result);
    }

    @Test
    void getRoom() {
        List<Room> result = service.getRooms();
        assertThat(result.size()).isGreaterThan(0);
    }

    @Test
    void getRooms() {
        Room result = service.getRoom(1);
        assertEquals(1, result.id());
    }
}