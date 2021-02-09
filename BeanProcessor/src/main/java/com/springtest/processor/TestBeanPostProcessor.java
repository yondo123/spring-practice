package com.springtest.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class TestBeanPostProcessor implements BeanPostProcessor{
	
	// init-method 호출 전
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("bean processor>> before"); //해당 bean의 객체주소 값
		System.out.println("before bean>>"+bean+"\n"+"beabName >>"+beanName); //해당 bean의 id 값
		return bean;
	}
	
	// init-method 호출 후
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("bean processor>> after");
		System.out.println("after bean>>"+bean+"\n"+"beabName >>"+beanName);
		return bean;
	}
}
