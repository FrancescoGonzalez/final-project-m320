package org.gonzalez.finalprojectm320.repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
import org.gonzalez.finalprojectm320.model.Reservation;
import org.gonzalez.finalprojectm320.model.Room;
import org.gonzalez.finalprojectm320.repository.interfaces.ReservationRepository;
import org.gonzalez.finalprojectm320.repository.mapper.ReservationMapper;
import org.gonzalez.finalprojectm320.repository.mapper.RoomMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcReservationRepository implements ReservationRepository {

  private final JdbcTemplate jdbcTemplate;

  private static final String INSERT = "INSERT INTO reservation (fk_customer, fk_room, number_of_people, check_in, check_out) VALUES (?, ?, ?, ?, ?);";
  private static final String SELECT_ALL = "SELECT * FROM reservation;";
  private static final String SELECT_BY_ID = "SELECT * FROM reservation WHERE id = ?;";
  private static final String UPDATE = "UPDATE reservation SET fk_customer = ?, fk_room = ?, number_of_people = ?, check_in = ?, check_out = ? WHERE id = ?;";

  @Autowired
  public JdbcReservationRepository(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  @Override
  public boolean createReservation(Reservation r) {
    KeyHolder keyHolder = new GeneratedKeyHolder();
    jdbcTemplate.update(connection -> {
      PreparedStatement ps = connection.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
      ps.setInt(1, r.getCustomerId());
      ps.setInt(2, r.getBookableId());
      ps.setInt(3, r.getNumberOfPeople());
      ps.setDate(4, java.sql.Date.valueOf(r.getCheckIn()));
      ps.setDate(5, java.sql.Date.valueOf(r.getCheckOut()));
      return ps;
    }, keyHolder);

    return keyHolder.getKey() != null && keyHolder.getKey().intValue() > 0;
  }

  @Override
  public List<Reservation> getReservations() {
    return jdbcTemplate.query(SELECT_ALL, new ReservationMapper());
  }

  @Override
  public Reservation getReservation(int id) {
    try {
      return jdbcTemplate.queryForObject(SELECT_BY_ID, new ReservationMapper(), id);
    } catch (EmptyResultDataAccessException e) {
      return null;
    }
  }

  @Override
  public boolean updateReservation(int id, Reservation updatedReservation) {
    int rowsAffected = jdbcTemplate.update(UPDATE,
        updatedReservation.getCustomerId(),
        updatedReservation.getBookableId(),
        updatedReservation.getNumberOfPeople(),
        java.sql.Date.valueOf(updatedReservation.getCheckIn()),
        java.sql.Date.valueOf(updatedReservation.getCheckOut()),
        id);

    return rowsAffected > 0;
  }

  @Override
  public boolean deleteReservation(int id) {
    return jdbcTemplate.update("DELETE FROM reservation WHERE id = ?;", id) > 0;
  }

  @Override
  public Room getReservationRoom(int id) {
    try {
      return jdbcTemplate.queryForObject("Select * from room where id = (Select fk_room from reservation where id = ?)", new RoomMapper(), id);
    } catch (EmptyResultDataAccessException e) {
      return null;
    }

  }
}
