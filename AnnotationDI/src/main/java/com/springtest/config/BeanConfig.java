package com.springtest.config;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

import com.springtest.beans.AutowireTypeBean;
import com.springtest.beans.AutowireBean;
import com.springtest.beans.DataBean;
import com.springtest.beans.SecondDataBean;
import com.springtest.beans.TestBean;

@Configuration
public class BeanConfig {
	// 생성자 방식
	@Bean
	@Lazy
	public TestBean beanJava() {
		return new TestBean(10, "constructor type", new DataBean());
	}

	// setter 방식
	@Bean
	public TestBean beanJavaSetter() {
		TestBean tb = new TestBean(); // 객체 생성
		tb.setNumber(200);
		tb.setString("setter type");
		tb.setBean(new DataBean());

		return tb;
	}

	// name 타입을 기준으로 자동주입 : 메소드의 이름과 맞춰준다.
	@Bean
	public DataBean data1() {
		return new DataBean();
	}

	@Bean
	public DataBean data2() {
		return new DataBean();
	}

	// name 기준의 자동 주입 설정
	@Bean(autowire = Autowire.BY_NAME)
	public AutowireBean autoName() {
		return new AutowireBean();
	}

	@Bean
	public SecondDataBean data() {
		return new SecondDataBean();
	}

	@Bean(autowire = Autowire.BY_TYPE)
	public AutowireTypeBean autoType() {
		return new AutowireTypeBean();
	}
}
