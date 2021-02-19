package com.springtest.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Component;

@Component("xmlPrice")
public class TestBean {
	private int price;
	@Autowired
	private TestData data;
	
	@Autowired
	@Qualifier("beanData")
	private TestDataSecond data2;
	
	@Autowired
	@Qualifier("beanData2")
	private TestDataSecond data3;

	public TestData getData() {
		return data;
	}
	
	public TestDataSecond getData2() {
		return data2;
	}

	public int getPrice() {
		return price;
	}
	

	//필수 주입 (ver 5.1~)
	public void setPrice(int price) {
		this.price = price;
	}
}
