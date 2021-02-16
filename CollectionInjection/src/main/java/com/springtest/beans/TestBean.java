package com.springtest.beans;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class TestBean {
	private List<String> listExam; //List (문자열형)
	private List<Integer> listRef; //List (정수형)
	private Set<String> setAddr; //set (문자열)
	private Map<String, Object> mapUserInfo; //map (object)

	//list
	public List<String> getListExam() {
		return listExam;
	}

	public void setListExam(List<String> listExam) { 
		this.listExam = listExam;
	}
	
	public List<Integer> getListRef() {
		return listRef;
	}

	public void setListRef(List<Integer> listRef) {
		this.listRef = listRef;
	}

	//map
	public Map<String, Object> getMapUserInfo() {
		return mapUserInfo;
	}

	public void setMapUserInfo(Map<String, Object> mapUserInfo) {
		this.mapUserInfo = mapUserInfo;
	}

	//set
	public Set<String> getSetAddr() {
		return setAddr;
	}

	public void setSetAddr(Set<String> setAddr) {
		this.setAddr = setAddr;
	}

}
