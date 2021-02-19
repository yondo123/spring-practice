package com.springtest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.springtest.beans.TestBean;
import com.springtest.beans.TestData;
import com.springtest.beans.TestDataSecond;

@Configuration
public class BeanConfig {
	@Bean
	public TestBean price(){
		return new TestBean();
	}
	
	@Bean
	public TestData data(){
		return new TestData();
	}
	
	@Bean
	public TestDataSecond beanData(){
		return new TestDataSecond();
	}
	
	@Bean
	public TestDataSecond beanData2(){
		return new TestDataSecond();
	}
}