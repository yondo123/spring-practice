package com.springtest.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springtest.beans.TestBean;
import com.springtest.beans.TestBeanSecond;

public class MainClass {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("com/springtest/config/beans.xml");
		TestBean test = ctx.getBean("data_bean", TestBean.class);
		System.out.println("dataBean>> " + test.getData());
		System.out.println("dataBean>> " + test.getData2());

		System.out.println("----------------------------------------");

		TestBeanSecond test2 = ctx.getBean("data_second_bean", TestBeanSecond.class);
		System.out.println("dataBeanSecond.data1>> " + test2.getData1());
		System.out.println("dataBeanSecond.data2>> " + test2.getData2());

		ctx.close();
	}

}
