package com.springtest.db;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.springtest.beans.JdbcBean;

@Component
public class JdbcDAO {
	// sql
	private String user_insert = "INSERT INTO USER(NAME, SEX, HOBBY) VALUES(?, ?, ?)";
	private String user_update = "UPDATE USER_TABLE SET HOBBY = ? WHERE NAME =?";
	private String user_delete = "DELETE USER_TABLE WHERE NAME=?";
	// jdbc 관리 객체(JdbcTemplate 주입)
	@Autowired
	private JdbcTemplate db;
	// Mapper클래스 주입
	@Autowired
	private MapperClass mp;

	// INSERT
	public void data_insert(JdbcBean bean) {
		// 각각의 insert 값에 binding
		db.update(user_insert, bean.getName(), bean.getSex(), bean.getHobby());
	}

	// SELECT
	public List<JdbcBean> data_select() {
		String sql = "SELECT NAME, HOBBY, SEX FROM USER_TABLE";
		List<JdbcBean> list = db.query(sql, mp);
		return list;
	}

	// UPDATE
	public void data_upadte(JdbcBean bean) {
		db.update(user_update, bean.getHobby(), bean.getName());
	}

	// DELETE
	public void data_delete(JdbcBean bean){
		db.update(user_delete, bean.getName());
	}
}
