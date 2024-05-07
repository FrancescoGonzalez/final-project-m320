package org.gonzalez.finalprojectm320.usecase;

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

    public Room getRoom(int id) {
        return repository.getRoom(id);
    }

    public java.util.List<Room> getRooms() {
        return repository.getRooms();
    }
}
