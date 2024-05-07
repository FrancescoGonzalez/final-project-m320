package org.gonzalez.finalprojectm320.repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
import org.gonzalez.finalprojectm320.model.Room;
import org.gonzalez.finalprojectm320.repository.interfaces.RoomRepository;
import org.gonzalez.finalprojectm320.repository.mapper.RoomMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
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

  public final String SELECT_BY_ID = "SELECT * FROM room WHERE id = ?;";
  private static final String SELECT_ALL = "SELECT * FROM room;";

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

  @Override
  public Room getRoom(int id) {
    try {
      return jdbcTemplate.queryForObject(SELECT_BY_ID, new Object[]{id}, new RoomMapper());
    } catch (EmptyResultDataAccessException e) {
      return null;
    }
  }

  @Override
  public List<Room> getRooms() {
    return jdbcTemplate.query(SELECT_ALL, new RoomMapper());
  }
}
