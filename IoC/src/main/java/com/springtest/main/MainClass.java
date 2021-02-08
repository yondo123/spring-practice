package com.springtest.main;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.cglib.proxy.Factory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;

import com.springtest.beans.TestBean;

public class MainClass {

	public static void main(String[] args) {
//		beanFactoryTest(); //
//		beanFactoryExternalTest();
//		contextTest();
		contextTestExternal();
	}
	
	//BeanFactory (내부 패키지)
	public static void beanFactoryTest(){
		ClassPathResource res = new ClassPathResource("com/springtest/config/beans.xml");
		XmlBeanFactory fty = new XmlBeanFactory(res);
		
		//Bean 객체 생성시 한번 생성된 객체를 보관 
		TestBean tb = fty.getBean("test", TestBean.class);
		System.out.printf("%s", tb);
		
		//다시 불러오더라도 이전에 사용한 객체 주소 참조
		TestBean tb2 = fty.getBean("test", TestBean.class);
		System.out.printf("%s", tb2);
	}
	
	//BeanFactory (외부 패키지)
	public static void beanFactoryExternalTest(){
		FileSystemResource res = new FileSystemResource("beans.xml");
		XmlBeanFactory fty = new XmlBeanFactory(res);
		
		TestBean tb = fty.getBean("secondTest",TestBean.class);
		System.out.printf("%s", tb);
	}
	
	//ApplicationContext (내부 패키지)
	public static void contextTest() {
		//xml 파일 로딩
		//default - 자동 생성 (설정에 따라 getBean 방식 설정)ㄴ
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("com/springtest/config/beans.xml");
		TestBean tb = ctx.getBean("test", TestBean.class); //이미 생성된 객체의 주소 값 사용
		System.out.printf("%s\n", tb);
		ctx.close();
	}
	
	//ApplicationContext (외부 패키지)
	public static void contextTestExternal(){
		FileSystemXmlApplicationContext ctx = new FileSystemXmlApplicationContext("beans.xml");
		ctx.close();
	}
}
