package org.gonzalez.finalprojectm320.repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import org.gonzalez.finalprojectm320.model.Room;
import org.gonzalez.finalprojectm320.repository.interfaces.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcRoomRepository implements RoomRepository {

  private final JdbcTemplate jdbcTemplate;

  @Autowired
  public JdbcRoomRepository(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  @Override
  public boolean createRoom(Room r) {
    KeyHolder keyHolder = new GeneratedKeyHolder();

    jdbcTemplate.update(connection -> {
      PreparedStatement ps = connection.prepareStatement("INSERT INTO room (room_number, room_type, max_people, price_per_person) VALUES (?, ?, ?, ?);",
          Statement.RETURN_GENERATED_KEYS);
      ps.setInt(1, r.number());
      ps.setString(2, r.type());
      ps.setInt(3, r.maxPeople());
      ps.setDouble(4, r.priceForPerson());


      return ps;
    }, keyHolder);

    return keyHolder.getKey().intValue() > 0;
  }
}
