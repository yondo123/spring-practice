package com.springtest.main;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import com.springtest.beans.TestBean;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		factoryTest();
	}
	
	//Bean Factory
	public static void factoryTest() {
		ClassPathResource res = new ClassPathResource("com/springtest/config/beans.xml");
		XmlBeanFactory fty = new XmlBeanFactory(res);
		
		TestBean test = fty.getBean("test", TestBean.class); //객체 생성후 IOC에서 보관 
		System.out.printf("test bean : %s\n", test);
	}
}
