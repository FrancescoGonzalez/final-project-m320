package org.gonzalez.finalprojectm320.repository.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import org.gonzalez.finalprojectm320.model.Reservation;
import org.springframework.jdbc.core.RowMapper;

public class ReservationMapper implements RowMapper<Reservation>{
  @Override
  public Reservation mapRow(ResultSet rs, int rowNum) throws SQLException {

    String[] timeArr1 = rs.getString("check_in").split("-");
    LocalDate checkIn = LocalDate.of(Integer.parseInt(timeArr1[0]), Integer.parseInt(timeArr1[1]), Integer.parseInt(timeArr1[2]));

    String[] timeArr2 = rs.getString("check_out").split("-");
    LocalDate checkOut = LocalDate.of(Integer.parseInt(timeArr2[0]), Integer.parseInt(timeArr2[1]), Integer.parseInt(timeArr2[2]));

    return new Reservation().createReservation(
        rs.getInt("id"),
        rs.getInt("fk_customer"),
        rs.getInt("fk_room"),
        rs.getInt("number_of_people"),
        checkIn,
        checkOut);
  }
}