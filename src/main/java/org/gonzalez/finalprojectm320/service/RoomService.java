package org.gonzalez.finalprojectm320.service;

import org.gonzalez.finalprojectm320.model.Room;
import org.gonzalez.finalprojectm320.repository.interfaces.RoomRepository;
import org.springframework.stereotype.Service;

@Service
public class RoomService {

    private final RoomRepository repository;

    public RoomService(RoomRepository roomRepository) {
        this.repository = roomRepository;
    }

    public boolean createRoom(Room r) {
        return repository.createRoom(r);
    }
}
