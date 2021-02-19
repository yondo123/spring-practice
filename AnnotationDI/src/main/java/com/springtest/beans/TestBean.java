package com.springtest.beans;

public class TestBean {
	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getString() {
		return string;
	}

	public void setString(String string) {
		this.string = string;
	}

	public Object getBean() {
		return bean;
	}

	public void setBean(Object bean) {
		this.bean = bean;
	}

	private int number;
	private String string;
	private Object bean;

	public TestBean() {

	}

	public TestBean(int number, String string, Object bean) {
		this.number = number;
		this.string = string;
		this.bean = bean;
	}

	public void showData() {
		System.out.println("number : " + number + "\n" + "String :" + string + "\n" + "Object : " + bean);
	}
}
