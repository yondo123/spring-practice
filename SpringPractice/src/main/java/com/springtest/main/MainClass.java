package com.springtest.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springtest.beans.HelloWorld;

public class MainClass {

	public static void main(String[] args) {
		// beans.xml로드 
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("com/springtest/config/beans.xml");
		
		// bean 객체의 주소값 로드 
		HelloWorld helo = (HelloWorld)ctx.getBean("hello"); //bean의 name 값 입력 
		callMethod(helo);
		
		HelloWorld helo2 = ctx.getBean("hello", HelloWorld.class); //두번째 방법 
		callMethod(helo2);
		ctx.close();
	}
	
	public static void callMethod(HelloWorld hello) {
		hello.sayHello();
	}
}