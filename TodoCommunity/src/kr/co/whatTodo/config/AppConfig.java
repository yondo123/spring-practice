package kr.co.whatTodo.config;

import javax.servlet.Filter;
import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class AppConfig extends AbstractAnnotationConfigDispatcherServletInitializer {
	// Dispatcher Servlet
	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}

	// SpringMVC setup class
	@Override
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		return new Class[] { ServletAppContext.class };
	}

	// Beans
	// Encoding Filter
	@Override
	protected Filter[] getServletFilters() {
		// TODO Auto-generated method stub
		CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();
		encodingFilter.setEncoding("UTF-8");
		return new Filter[] { encodingFilter };
	}

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return new Class[] { RootAppContext.class };
	}
	
	@Override
	protected void customizeRegistration(Dynamic registration) {
		// TODO Auto-generated method stub
		super.customizeRegistration(registration);
		//임시파일 경로, 업로드 용량(Byte, 50MB), 전체 요청정보 용량(파일데이터 포함), 파일 임계값
		MultipartConfigElement config = new MultipartConfigElement(null, 52428800, 524288000, 0);
		registration.setMultipartConfig(config);
	}
}
