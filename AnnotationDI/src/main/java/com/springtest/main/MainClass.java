package com.springtest.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.springtest.beans.AutowireBean;
import com.springtest.beans.AutowireTypeBean;
import com.springtest.beans.TestBean;
import com.springtest.config.BeanConfig;

public class MainClass {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext acx = new AnnotationConfigApplicationContext(BeanConfig.class);

		TestBean tb = acx.getBean("beanJava", TestBean.class);
		tb.showData();

		System.out.println("------------------------------------");

		TestBean tb2 = acx.getBean("beanJavaSetter", TestBean.class);
		tb2.showData();
				
		System.out.println("------------------------------------");
		AutowireBean ab1 = acx.getBean("autoName", AutowireBean.class);
		System.out.println("autowire >> getData1" + ab1.getData1());
		System.out.println("autowire >> getData2" + ab1.getData2());
		
		System.out.println("------------------------------------");
		AutowireTypeBean ab2 = acx.getBean("autoType", AutowireTypeBean.class);
		System.out.println("autowire(Type) >> getData1" + ab2.getData1());
		System.out.println("autowire(Type) >> getData2" + ab2.getData2());
		acx.close();
	}

}
