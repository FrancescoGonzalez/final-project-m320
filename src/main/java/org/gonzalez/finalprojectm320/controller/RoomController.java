package org.gonzalez.finalprojectm320.controller;

import org.gonzalez.finalprojectm320.model.Room;
import org.gonzalez.finalprojectm320.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoomController {

    @Autowired
    private RoomService service;

    @PostMapping("/room")
    boolean createRoom(@RequestBody Room r) {
        return service.createRoom(r);
    }
}
