package com.springtest.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springtest.beans.FirstTestBean;
import com.springtest.beans.SecondTestBean;
import com.springtest.beans.ThirdTestBean;
import com.springtest.config.BeanConfig;

public class MainClass {
	public static void main(String[] args) {
		// XML File 방식
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("com/springtest/config/beans.xml");
		FirstTestBean xfb = ctx.getBean("beanXml", FirstTestBean.class);
		System.out.println("Xml FirstBean >> " + xfb);
		ctx.close();

		// Java File 방식
		// BeanConfig의 메소드를 호출하지 않아도 Bean 객체 호출
		AnnotationConfigApplicationContext acx = new AnnotationConfigApplicationContext(BeanConfig.class);
		FirstTestBean afb = acx.getBean("beanJava", FirstTestBean.class);
		System.out.println("Java FirstBean, beanJava >> " + afb);

		FirstTestBean afb2 = acx.getBean("newBean", FirstTestBean.class);
		System.out.println("Java FirstBean, newBean >> " + afb2);

		// Lazy Test
		System.out.println("-------------------------------Lazy Test-----------------------------");
		
		SecondTestBean asb = acx.getBean("secondBean", SecondTestBean.class);
		System.out.println("Java SecondBean, secondBean >> " + asb);

		SecondTestBean asb2 = acx.getBean("secondBean", SecondTestBean.class);
		System.out.println("Java SecondBean, secondBean >> " + asb2);
		
		// Scope Prototype Test
		System.out.println("-------------------------------Scope Test-----------------------------");
		
		ThirdTestBean atb = acx.getBean("thirdBean", ThirdTestBean.class);
		System.out.println("Java ThirdBean, thirdBean >> " + atb);

		ThirdTestBean atb2 = acx.getBean("thirdBean", ThirdTestBean.class);
		System.out.println("Java ThirdBean, thirdBean >> " + atb2);
		acx.close();
	}
}
