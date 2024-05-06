package org.gonzalez.finalprojectm320.repository.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.gonzalez.finalprojectm320.model.Customer;
import org.springframework.jdbc.core.RowMapper;

public class CustomerMapper implements RowMapper<Customer>{
  @Override
  public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {

    return new Customer(
        rs.getInt("id"),
        rs.getString("first_name"),
        rs.getString("last_name"),
        rs.getString("birth_date"),
        rs.getString("nationality"));
  }
}