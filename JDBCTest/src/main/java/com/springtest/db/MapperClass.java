package com.springtest.db;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import org.springframework.stereotype.Component;

import com.springtest.beans.JdbcBean;

@Component
public class MapperClass implements RowMapper<JdbcBean> {
	public JdbcBean mapRow(ResultSet rs, int rowNum) throws SQLException {
		JdbcBean bean = new JdbcBean();
		bean.setName(rs.getString("NAME"));
		bean.setSex(rs.getString("SEX"));
		bean.setHobby(rs.getString("HOBBY"));

		return bean;
	}
}
