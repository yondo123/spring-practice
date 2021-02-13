package com.springtest.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springtest.beans.TestBean;

public class MainClass {

	public static void main(String[] args) {
		TestBean obj = new TestBean();
		obj.setData1(100);
		System.out.println("obj data : " + obj.getData1());

		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("com/springtest/conf/beans.xml");
		TestBean t1 = ctx.getBean("t1", TestBean.class);

		System.out.println("t1.data1 (Integer) : " + t1.getData1());
		System.out.println("t1.data2 (Double) : " + t1.getData2());
		System.out.println("t1.data3 (Bool) : " + t1.getData3());
		System.out.println("t1.data4 (Stirng) : " + t1.getData4());
		System.out.println("t1.DataBean (Class Object) : " + t1.getDataBean());
		System.out.println("t1.DataBean, ref (Class Object) : " + t1.getData5());
		ctx.close();
	}
}
