package com.springtest.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
@ComponentScan(basePackages = { "com.springtest.beans", "com.springtest.db" })
public class BeanConfig {
	// DB 접속 후 쿼리 전달
	// 외부 라이브러리 클래스 - @Bean
	// 직접 생성한 클래스 - @Component
	@Bean
	public BasicDataSource source() {
		BasicDataSource src = new BasicDataSource();
		// DBMS 접속정보 생성
		src.setDriverClassName("oracle.jdbc.OracleDriver");
		src.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		src.setUsername("spring");
		src.setPassword("spring");
		return src;
	}

	// BasicDataSource 객체 자동 주입
	@Bean
	public JdbcTemplate db(BasicDataSource source) {
		// 데이터 소스 (접속정보 가지고 있는 객체, DBCP)
		JdbcTemplate db = new JdbcTemplate(source);
		return db;
	}

}
