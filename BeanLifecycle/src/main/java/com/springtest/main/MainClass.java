package com.springtest.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springtest.beans.TestBeanFirst;
import com.springtest.beans.TestBeanSecond;

public class MainClass {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("com/springtest/config/beans.xml");
		TestBeanFirst test1 = ctx.getBean("testBeanFirst", TestBeanFirst.class);
		System.out.printf("testBeanFirst>> %s\n", test1);
		System.out.println("-------------------------------------------------------");
		TestBeanSecond test2 = ctx.getBean("testBeanSec", TestBeanSecond.class);
		System.out.printf("testBeanSecond>> %s\n", test2);
		ctx.close(); //IoC 컨테이너 종료
	}
}
