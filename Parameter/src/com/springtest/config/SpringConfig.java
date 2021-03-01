package com.springtest.config;

import javax.servlet.Filter;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

//public class SpringConfig implements WebApplicationInitializer {
//
//	// web.xml 대신 onstartup 메소드 load (web.xml 역할)
//	@Override
//	public void onStartup(ServletContext servletContext) throws ServletException {
//		AnnotationConfigWebApplicationContext servletAppContext = new AnnotationConfigWebApplicationContext();
//		servletAppContext.register(ServletAppContext.class);
//
//		// dispatcher servlet (요청 발생 시 처리)
//		DispatcherServlet dispatcherServlet = new DispatcherServlet(servletAppContext);
//		ServletRegistration.Dynamic servlet = servletContext.addServlet("dispatcher", dispatcherServlet);
//
//		// 요청 서블릿 설정
//		servlet.setLoadOnStartup(1);
//		servlet.addMapping("/");
//
//		// bean 정의
//		AnnotationConfigWebApplicationContext rootAppContext = new AnnotationConfigWebApplicationContext();
//		rootAppContext.register(RootAppContext.class);
//
//		// 리스너 설정
//		ContextLoaderListener listner = new ContextLoaderListener(rootAppContext);
//		servletContext.addListener(listner);
//
//		// Encoding Filter
//		FilterRegistration.Dynamic filter = servletContext.addFilter("encodingFilter", CharacterEncodingFilter.class);
//		filter.setInitParameter("encoding", "UTF-8");
//		filter.addMappingForServletNames(null, false, "dispatcher");
//	}
//}

public class SpringConfig extends AbstractAnnotationConfigDispatcherServletInitializer{
	//Dispatcher Servlet
	@Override
	protected String[] getServletMappings() {
		return new String[] {"/"};
	}
	
	//SpringMVC setup class
	@Override
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		return new Class[] {ServletAppContext.class};
	}
	
	//Beans
	//Encoding Filter
	@Override
	protected Filter[] getServletFilters() {
		// TODO Auto-generated method stub
		CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();
		encodingFilter.setEncoding("UTF-8");
		return new Filter[] {encodingFilter};
	}

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return null;
	}
}
