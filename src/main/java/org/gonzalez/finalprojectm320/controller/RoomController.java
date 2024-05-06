package org.gonzalez.finalprojectm320.controller;

import org.gonzalez.finalprojectm320.model.Room;
import org.gonzalez.finalprojectm320.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoomController {

    @Autowired
    private ReservationService service;

    @PutMapping("/create-room")
    boolean createRoom(@RequestBody Room r) {
        return service.createRoom(r);
    }
}
