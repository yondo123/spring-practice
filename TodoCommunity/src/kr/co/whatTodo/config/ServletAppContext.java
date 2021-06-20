package kr.co.whatTodo.config;

import javax.annotation.Resource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import kr.co.whatTodo.batch.ScheduleRepository;
import kr.co.whatTodo.beans.UserInfoBean;
import kr.co.whatTodo.interceptor.MenuInterceptor;
import kr.co.whatTodo.mapper.BoardMapper;
import kr.co.whatTodo.mapper.MenuMapper;
import kr.co.whatTodo.mapper.UserMapper;
import kr.co.whatTodo.service.MenuService;

//Spring MVC Project 설정
@Configuration
//scheduling 
@EnableScheduling
//annotation-driven
@EnableWebMvc
//component-scan
@ComponentScan("kr.co.whatTodo.controller")
@ComponentScan("kr.co.whatTodo.dao")
@ComponentScan("kr.co.whatTodo.service")

@PropertySource("/WEB-INF/properties/db.properties")
public class ServletAppContext implements WebMvcConfigurer {
	@Value("${db.classname}")
	private String db_classname;

	@Value("${db.url}")
	private String db_url;

	@Value("${db.username}")
	private String db_username;

	@Value("${db.password}")
	private String db_password;

	@Resource(name = "loginUserInfoBean")
	private UserInfoBean userInfoBean;

	@Autowired
	private MenuService menuService;

	// scheduling
	@Bean
	public ScheduleRepository scheduleRepository() {
		return new ScheduleRepository();
	}

	// Controller 반환 view
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		WebMvcConfigurer.super.configureViewResolvers(registry);
		registry.jsp("/WEB-INF/views/html/", ".jsp");
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resource/**").addResourceLocations("/resource/");
	}

	// database
	@Bean
	public BasicDataSource dataSource() {
		BasicDataSource source = new BasicDataSource();
		System.out.println(db_username + ", " + db_password);
		source.setDriverClassName(db_classname);
		source.setUrl(db_url);
		source.setUsername(db_username);
		source.setPassword(db_password);
		return source;
	}

	@Bean
	public SqlSessionFactory factory(BasicDataSource source) throws Exception {
		SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
		factoryBean.setDataSource(source);
		SqlSessionFactory factory = factoryBean.getObject();
		return factory;
	}

	@Bean
	public MapperFactoryBean<BoardMapper> getBoardMapper(SqlSessionFactory factory) throws Exception {
		MapperFactoryBean<BoardMapper> factoryBean = new MapperFactoryBean<BoardMapper>(BoardMapper.class);
		factoryBean.setSqlSessionFactory(factory);
		return factoryBean;
	}

	@Bean
	public MapperFactoryBean<MenuMapper> getMenuMapper(SqlSessionFactory factory) throws Exception {
		MapperFactoryBean<MenuMapper> factoryBean = new MapperFactoryBean<MenuMapper>(MenuMapper.class);
		factoryBean.setSqlSessionFactory(factory);
		return factoryBean;
	}

	@Bean
	public MapperFactoryBean<UserMapper> getUserMapper(SqlSessionFactory factory) throws Exception {
		MapperFactoryBean<UserMapper> factoryBean = new MapperFactoryBean<UserMapper>(UserMapper.class);
		factoryBean.setSqlSessionFactory(factory);
		return factoryBean;
	}

	/**
	 * @desc : 메뉴 인터셉터
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		WebMvcConfigurer.super.addInterceptors(registry);

		MenuInterceptor menuInterceptor = new MenuInterceptor(menuService, userInfoBean);
		InterceptorRegistration reg = registry.addInterceptor(menuInterceptor);
		reg.addPathPatterns("/**"); // all requests
	}

	/**
	 * @desc : 메세지 프로퍼티를 위한 새로운 Bean 생성
	 */
	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}

	/**
	 * @desc : 에러메시지 정의 프로퍼티
	 */
	@Bean
	public ReloadableResourceBundleMessageSource messageSource() {
		ReloadableResourceBundleMessageSource res = new ReloadableResourceBundleMessageSource();
		res.setBasenames("/WEB-INF/properties/errorMessage");
		return res;
	}

	/**
	 * multipasrt Resolver Bean 등록
	 */
	@Bean
	public StandardServletMultipartResolver multipartResolver() {
		return new StandardServletMultipartResolver();
	}

}
