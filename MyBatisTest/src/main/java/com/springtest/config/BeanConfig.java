package com.springtest.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.springtest.mapper.MapperInterface;

@Configuration
@ComponentScan(basePackages = "com.springtest.beans")
public class BeanConfig {
	// dbcp datasource
	@Bean
	public BasicDataSource dataSource() {
		BasicDataSource src = new BasicDataSource();
		src.setDriverClassName("oracle.jdbc.OracleDriver");
		src.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		src.setUsername("spring");
		src.setPassword("spring");
		return src;
	}

	// SqlSessionFactory (JDBC 처리 객체)
	// BasicDataSource 주입
	@Bean
	public SqlSessionFactory factory(BasicDataSource src) throws Exception {
		SqlSessionFactoryBean factoryBaan = new SqlSessionFactoryBean();
		factoryBaan.setDataSource(src);
		SqlSessionFactory factory = factoryBaan.getObject();
		return factory;
	}

	// Mapper
	// SqlSessionFactory 주입
	// 다수의 mapper 관리를 위해 bean 호출 시 name으로 호출
	@Bean
	public MapperFactoryBean<MapperInterface> usertbl_mapper(SqlSessionFactory factory) throws Exception {
		MapperFactoryBean<MapperInterface> factoryBean = new MapperFactoryBean<MapperInterface>(MapperInterface.class);
		factoryBean.setSqlSessionFactory(factory);
		return factoryBean;
	}
}
