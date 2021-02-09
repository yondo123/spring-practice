package com.springtest.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springtest.beans.FirstBeanTest;
import com.springtest.beans.SecondBeanTest;

public class MainClass {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("com/springtest/config/beans.xml");
		
		FirstBeanTest fb = ctx.getBean("fb", FirstBeanTest.class);
		System.out.printf("firstBean Addr %s", fb);
		System.out.println("-------------------------------------");
		SecondBeanTest sb = ctx.getBean("sb", SecondBeanTest.class);
		System.out.printf("secondBean Addr %s", sb);
		
		ctx.close();
	}

}
