package com.springtest.beans;

public class AutowireTypeBean {
	private SecondDataBean data1;
	private SecondDataBean data2;

	public SecondDataBean getData1() {
		return data1;
	}

	public void setData1(SecondDataBean data1) {
		this.data1 = data1;
	}

	public SecondDataBean getData2() {
		return data2;
	}

	public void setData2(SecondDataBean data2) {
		this.data2 = data2;
	}
}
