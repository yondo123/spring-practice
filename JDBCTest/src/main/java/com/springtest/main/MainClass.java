package com.springtest.main;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.springtest.beans.JdbcBean;
import com.springtest.config.BeanConfig;
import com.springtest.db.JdbcDAO;

public class MainClass {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext acx = new AnnotationConfigApplicationContext(BeanConfig.class);

		// DAO
		JdbcDAO dao = acx.getBean(JdbcDAO.class);
		JdbcBean yoshi = new JdbcBean();
		yoshi.setName("yoshi");
		yoshi.setSex("M");
		yoshi.setHobby("먹기");
		dao.data_insert(yoshi);

		JdbcBean boo = new JdbcBean();
		boo.setName("boo");
		boo.setSex("F");
		boo.setHobby("movie");
		dao.data_insert(boo);

		System.out.println("Success Insert Data!!");
		
		JdbcBean update = new JdbcBean();
		update.setName("boo");
		update.setHobby("자기");
		dao.data_upadte(update);
		
		JdbcBean delete = new JdbcBean();
		delete.setName("yoshi");
		dao.data_delete(delete);
		
		List<JdbcBean> list = dao.data_select();
		for (JdbcBean data : list) {
			System.out.println("name : " + data.getName());
			System.out.println("gender : " + data.getSex());
			System.out.println("hobby : " + data.getHobby());
			System.out.println("-----------------------------");
		}
		acx.close();
	}

}
