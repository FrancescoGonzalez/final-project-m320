package org.gonzalez.finalprojectm320.repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
import org.gonzalez.finalprojectm320.model.Reservation;
import org.gonzalez.finalprojectm320.repository.interfaces.ReservationRepository;
import org.gonzalez.finalprojectm320.repository.mapper.ReservationMapper;
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
    try {
      if (!checkAvailability(r.bookableId(), java.sql.Date.valueOf(r.checkIn()), java.sql.Date.valueOf(r.checkOut()))) {
        return false;
      }
      KeyHolder keyHolder = new GeneratedKeyHolder();
      jdbcTemplate.update(connection -> {
        PreparedStatement ps = connection.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
        ps.setInt(1, r.customerId());
        ps.setInt(2, r.bookableId());
        ps.setInt(3, r.numberOfPeople());
        ps.setDate(4, java.sql.Date.valueOf(r.checkIn()));
        ps.setDate(5, java.sql.Date.valueOf(r.checkOut()));
        return ps;
      }, keyHolder);

      return keyHolder.getKey() != null && keyHolder.getKey().intValue() > 0;
    } catch (Exception e) {
      return false;
    }
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
            updatedReservation.customerId(),
            updatedReservation.bookableId(),
            updatedReservation.numberOfPeople(),
            java.sql.Date.valueOf(updatedReservation.checkIn()),
            java.sql.Date.valueOf(updatedReservation.checkOut()),
            id);
    return rowsAffected > 0;

  }

  @Override
  public boolean deleteReservation(int id) {
    return jdbcTemplate.update("DELETE FROM reservation WHERE id = ?;", id) > 0;
  }

  @Override
  public boolean checkAvailability(int bookableId, java.sql.Date checkIn, java.sql.Date checkOut) {
    return jdbcTemplate.queryForObject("SELECT COUNT(*) FROM reservation WHERE fk_room = ? AND check_in <= ? AND check_out >= ?;", Integer.class, bookableId, checkOut, checkIn) == 0;
  }




}
