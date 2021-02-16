package com.springtest.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springtest.beans.TestBean;

public class MainClass {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new  ClassPathXmlApplicationContext("com/springtest/config/beans.xml");
		TestBean bo = ctx.getBean("testObj1", TestBean.class);
		bo.printData();
		
		System.out.println("-----------------------------------");
		TestBean bo2 = ctx.getBean("testObj2", TestBean.class);
		bo2.printData();
		ctx.close();
	}
}
