package com.springtest.beans;

public class TestBeanFirst {
	public TestBeanFirst(){
		System.out.println("TestBeanFirst Constructor!!");
	}
	
	//init 메소드 등록
	public void firstBean_init(){
		System.out.println("TestBeanFirst Init!!");
	}
	
	//destroy 메소드 등록
	public void firstBean_destroy(){
		System.out.println("TestBeanFirst Destroy!!");
	}
}
