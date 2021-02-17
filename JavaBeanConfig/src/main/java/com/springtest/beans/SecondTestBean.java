package com.springtest.beans;

public class SecondTestBean {
	public SecondTestBean() {
		System.out.println("SecondTestBean Constructor!!");
	}
	
	//init 메소드
	public void init(){
		System.out.println("init Method!!");
	}
	
	//destroy 메소드
	public void destroy(){
		System.out.println("destroy Method!!");
	}
}
