package org.gonzalez.finalprojectm320.repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
import org.gonzalez.finalprojectm320.model.Customer;
import org.gonzalez.finalprojectm320.repository.mapper.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcCustomerRepository implements CustomerRepository {

  private final JdbcTemplate jdbcTemplate;

  private static final String INSERT_CUSTOMER = "INSERT INTO customer (first_name, last_name, birth_date, nationality) VALUES (?, ?, ?, ?);";
  private static final String SELECT_CUSTOMERS = "SELECT * FROM customer;";

  @Autowired
  public JdbcCustomerRepository(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  @Override
  public boolean createCustomer(Customer c) {
    KeyHolder keyHolder = new GeneratedKeyHolder();

    jdbcTemplate.update(connection -> {
      PreparedStatement ps = connection.prepareStatement(INSERT_CUSTOMER,
          Statement.RETURN_GENERATED_KEYS);
      ps.setString(1, c.firstName());
      ps.setString(2, c.lastName());
      ps.setString(3, c.birthDate());
      ps.setString(4, c.nationality());
      return ps;
    }, keyHolder);

    return keyHolder.getKey().intValue() > 0;
  }

  @Override
  public List<Customer> getCustomers() {
    return jdbcTemplate.query(SELECT_CUSTOMERS, new CustomerMapper());
  }
}
