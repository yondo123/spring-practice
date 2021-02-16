package com.springtest.main;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springtest.beans.TestBean;

public class MainClass {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("com/springtest/config/beans.xml");

		TestBean test = ctx.getBean("test", TestBean.class);
		List<String> testExam = test.getListExam();

		for (int i = 0; i < testExam.size(); i++) {
			System.out.println("listSample :" + testExam.get(i));
		}

		List<Integer> testExam2 = test.getListRef();
		for (int i = 0; i < testExam2.size(); i++) {
			System.out.println("listSample 2 :" + testExam2.get(i));
		}

		System.out.println("----------------------------------------");
		// Set
		Set<String> testSet = test.getSetAddr();
		for (String str : testSet) {
			System.out.println("set values : " + str);
		}

		// Map
		System.out.println("----------------------------------------");
		Map<String, Object> map = test.getMapUserInfo();
		String userId = (String) map.get("userId");
		String userPw = (String) map.get("userPw");
		int authCd = (Integer) map.get("authCode");
		List<String> menuList = (List<String>) map.get("accessMenu");

		System.out.println("ID : " + userId);
		System.out.println("PW : " + userPw);
		System.out.println("CD : " + authCd);
		for (String menu : menuList) {
			System.out.println("menu : " + menu);
		}
		ctx.close();
	}

}
