package org.gonzalez.finalprojectm320.controller;

import java.util.List;
import org.gonzalez.finalprojectm320.model.Room;
import org.gonzalez.finalprojectm320.usecase.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class RoomController {

    @Autowired
    private RoomService service;

    @PostMapping("/room")
    boolean createRoom(@RequestBody Room r) {
        return service.createRoom(r);
    }

    @GetMapping("/room")
    List<Room> getRooms() {
        return service.getRooms();
    }

    @GetMapping("/room/{id}")
    Room getRoom(@PathVariable int id) {
        return service.getRoom(id);
    }
}

