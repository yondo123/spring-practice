package com.springtest.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springtest.beans.TestBean;

public class MainClass {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("com/springtest/config/beans.xml");

		// xml에 정의된 id값을 참조해 주소값을 가져온다.
		TestBean t1 = ctx.getBean("defaultBean", TestBean.class);
		System.out.printf("defaultBean>> %s\n", t1);

		TestBean t2 = ctx.getBean("defaultBean", TestBean.class);
		System.out.printf("defaultBean>> %s\n", t2);

		// id가 bean2인 객체의 주소 가져옴
		TestBean t3 = ctx.getBean("lazyinitBean", TestBean.class);
		System.out.printf("lazyinitBean>> %s\n", t3);
		
		TestBean t4 = ctx.getBean("lazyinitBean", TestBean.class);
		System.out.printf("lazyinitBean>> %s\n", t4);

		// id가 bean3인 객체의 주소 가져옴
		TestBean t5 = ctx.getBean("prototypeBean", TestBean.class);
		System.out.printf("prototypeBean>> %s\n", t5);
		
		TestBean t6 = ctx.getBean("prototypeBean", TestBean.class);
		System.out.printf("prototypeBean>> %s\n", t6);
		ctx.close();
	}
}
