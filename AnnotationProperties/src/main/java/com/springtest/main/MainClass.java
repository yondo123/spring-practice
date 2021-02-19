package com.springtest.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springtest.beans.ConstructorTestBean;
import com.springtest.beans.TestBean;
import com.springtest.config.BeanConfig;

public class MainClass {
	public static void main(String[] args) {
		System.out.println("--------------------XML-------------------");
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("com/springtest/config/beans.xml");
		TestBean xml = ctx.getBean("xmlPrice", TestBean.class);
		System.out.println("price : " + xml.getPrice());
		System.out.println("Object Data :" + xml.getData());
		System.out.println("Qualifier Test : " + xml.getData() + " -- " + xml.getData2());

		ConstructorTestBean conXml = ctx.getBean("xmlConstructor", ConstructorTestBean.class);
		System.out.println("Ref Object A : " + conXml.getDataObjectA());
		System.out.println("Ref Object B : " + conXml.getDataObjectB());
		System.out.println("int Data : " + conXml.getDataA());
		System.out.println("String Data : " + conXml.getDataB());
		ctx.close();

		System.out.println("-----------------Annotation---------------");
		AnnotationConfigApplicationContext acx = new AnnotationConfigApplicationContext(BeanConfig.class);
		TestBean ano = acx.getBean("price", TestBean.class);
		System.out.println("price : " + ano.getPrice());
		System.out.println("Object Data : " + ano.getData());
		System.out.println("Qualifier Test : " + ano.getData() + " -- " + ano.getData2());

		acx.close();
	}
}