package org.gonzalez.finalprojectm320.repository.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.gonzalez.finalprojectm320.model.Room;
import org.springframework.jdbc.core.RowMapper;

public class RoomMapper implements RowMapper<Room>{
  @Override
  public Room mapRow(ResultSet rs, int rowNum) throws SQLException {

    return new Room(
        rs.getInt("id"),
        rs.getInt("room_number"),
        rs.getString("room_type"),
        rs.getInt("max_people"),
        rs.getDouble("price_per_person"));
  }
}