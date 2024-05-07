package org.gonzalez.finalprojectm320.repository.interfaces;

import java.util.List;
import org.gonzalez.finalprojectm320.model.Room;

public interface RoomRepository {
    boolean createRoom(Room r);
    Room getRoom(int id);
    List<Room> getRooms();
}
