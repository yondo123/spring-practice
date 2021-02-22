package com.springtest.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springtest.beans.FirstBean;

public class MainClass {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("com/springtest/config/beans.xml");
		FirstBean fb = ctx.getBean("xmlFirstBean", FirstBean.class);
		String around = fb.displayHello();

		System.out.println("around return :" + around);
		ctx.close();
	}
}
