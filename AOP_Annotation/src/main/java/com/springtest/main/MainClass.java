package com.springtest.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.springtest.beans.FirstBean;
import com.springtest.config.BeanConfig;

public class MainClass {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext acx = new AnnotationConfigApplicationContext(BeanConfig.class);
		FirstBean fb = acx.getBean(FirstBean.class);
		fb.displayHello();
		acx.close();
	}
}
