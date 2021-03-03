package com.springtest.beans;

public class DataBean {
	private String name;
	private int visitCnt;
	private String location;
	private boolean isOpen;
	
	//데이터 생성을 위한 임시 생성자
	public DataBean(String name, int visitCnt, String location, boolean isOpen) {
		this.name = name;
		this.visitCnt = visitCnt;
		this.location = location;
		this.isOpen = isOpen;
	}

	public boolean isOpen() {
		return isOpen;
	}

	public void setOpen(boolean isOpen) {
		this.isOpen = isOpen;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getVisitCnt() {
		return visitCnt;
	}

	public void setVisitCnt(int visitCnt) {
		this.visitCnt = visitCnt;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

}
