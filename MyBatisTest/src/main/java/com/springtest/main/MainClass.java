package com.springtest.main;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.springtest.beans.UserVO;
import com.springtest.config.BeanConfig;
import com.springtest.mapper.MapperInterface;

public class MainClass {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext acx = new AnnotationConfigApplicationContext(BeanConfig.class);
		MapperInterface mapper = acx.getBean("usertbl_mapper", MapperInterface.class);

		// select
		List<UserVO> list = mapper.selectData();
		for (UserVO userList : list) {
			System.out.println(userList.getName());
			System.out.println(userList.getSex());
			System.out.println(userList.getHobby());
		}

		// INSERT
		UserVO bean = new UserVO();
		bean.setName("mario");
		bean.setSex("F");
		bean.setHobby("Adventure");
		mapper.insertData(bean);
		acx.close();
	}

}
