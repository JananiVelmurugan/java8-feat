package com.janani.lambda;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;

public class ex3 {
	public static void main(String[] args) {
		// Example of JdbcTemplate usage before lambdas
		JdbcTemplate jdbcTemplate = null;
		jdbcTemplate.query("SELECT id FROM person WHERE email = ?", new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, "jan@gmail.com");
			}
		}, new RowMapper<Person>() {
			@Override
			public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new Person(rs.getInt(1));
			}
		});
		// Example of JdbcTemplate usage with lambdas
		jdbcTemplate.query("SELECT id FROM person WHERE email = ?", ps -> ps.setString(1, "jan@gmail.com"),
				(rs, rowNum) -> new Person(rs.getInt(1)));
	}
}
