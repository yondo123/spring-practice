package com.springtest.beans;

import org.springframework.stereotype.Component;

@Component
public class FirstBean {
	public void displayHello(){
		System.out.println("FirstBean : hello~ spring");
	}
}
