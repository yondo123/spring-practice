package com.springtest.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("xmlConstructor")
public class ConstructorTestBean {
	private int dataA;
	private String dataB;
	private ConTestDataFirst dataObjectA;
	private ConTestDataSecond dataObjectB;

	public ConstructorTestBean(@Value("777") int dataA, @Value("String~~") String dataB, ConTestDataFirst dataObjA,
			ConTestDataSecond dataObjB) {
		this.dataA = dataA;
		this.dataB = dataB;

		// type 기준으로 자동 주입 발생
		this.dataObjectA = dataObjA;
		this.dataObjectB = dataObjB;
	}

	public int getDataA() {
		return dataA;
	}

	public String getDataB() {
		return dataB;
	}

	public ConTestDataFirst getDataObjectA() {
		return dataObjectA;
	}

	public ConTestDataSecond getDataObjectB() {
		return dataObjectB;
	}

}

