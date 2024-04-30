package org.gonzalez.finalprojectm320.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Object test() {
        return jdbcTemplate.query("SELECT * FROM tua_tabella", new TuaEntitaRowMapper());
    }
}
