package com.springtest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

import com.springtest.beans.FirstTestBean;
import com.springtest.beans.SecondTestBean;
import com.springtest.beans.ThirdTestBean;

@Configuration 
public class BeanConfig {
	
	@Bean //bean 정의 Annotation
	public FirstTestBean beanJava(){ //메소드의 이름이 Bean Id
		FirstTestBean ftb = new FirstTestBean(); //bean객체 생성 
		return ftb;
	}
	
	@Bean(name="newBean") //반환하는 객체의 ID가 메소드명이아닌 명시된 name으로 반환
	public FirstTestBean beanJava2(){
		FirstTestBean ftb = new FirstTestBean();
		return ftb;
	}
	
	@Bean(initMethod="init", destroyMethod="destroy")
	@Lazy
	public SecondTestBean secondBean(){
		SecondTestBean stb = new SecondTestBean();
		return stb;
	}
	
	@Bean
	@Scope("prototype")
	public ThirdTestBean thirdBean(){
		ThirdTestBean ttb = new ThirdTestBean();
		return ttb;
	}
}