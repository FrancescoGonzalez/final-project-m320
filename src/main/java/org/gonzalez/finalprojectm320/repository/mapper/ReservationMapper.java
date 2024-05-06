package org.gonzalez.finalprojectm320.repository.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.gonzalez.finalprojectm320.model.Reservation;
import org.springframework.jdbc.core.RowMapper;

public class ReservationMapper implements RowMapper<Reservation>{
  @Override
  public Reservation mapRow(ResultSet rs, int rowNum) throws SQLException {

    return new Reservation(
        rs.getInt("id"),
        rs.getInt("fk_customer"),
        rs.getInt("fk_room"),
        rs.getInt("number_of_people"),
        rs.getString("check_in"),
        rs.getString("check_out"));
  }
}