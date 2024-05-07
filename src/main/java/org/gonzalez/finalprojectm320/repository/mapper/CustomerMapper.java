package org.gonzalez.finalprojectm320.repository.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import org.gonzalez.finalprojectm320.model.Customer;
import org.springframework.jdbc.core.RowMapper;

public class CustomerMapper implements RowMapper<Customer>{
  @Override
  public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
    String[] time = rs.getString("birth_date").split("-");
    LocalDate birthDate = LocalDate.of(Integer.parseInt(time[0]), Integer.parseInt(time[1]), Integer.parseInt(time[2]));

    return new Customer(
        rs.getInt("id"),
        rs.getString("first_name"),
        rs.getString("last_name"),
        birthDate,
        rs.getString("nationality"));
  }
}