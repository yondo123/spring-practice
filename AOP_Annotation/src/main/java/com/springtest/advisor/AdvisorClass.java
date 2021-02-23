package com.springtest.advisor;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AdvisorClass {

	// 해당 비즈니스 메소드(..displayHello())가 실행되는 시점을 pointcut
	@Pointcut("execution(* com.springtest.beans.*Bean.displayHello(..));")
	public void allPointcut() {
	}

	@Before("allPointcut()")
	public void beforeMethod() {
		System.out.println("before Method!");
	}

	@After("allPointcut()")
	public void afterMethod() {
		System.out.println("after Method!");
	}

	@Around("allPointcut()")
	public Object aroundMethod(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("around Method!");
		Object result = pjp.proceed();
		return result;
	}
	
	@AfterReturning("allPointcut()")
	public void successCall(){
		System.out.println("Success Call Method!");
	}
	
	@AfterThrowing("allPointcut()")
	public void failCall(){
		System.out.println("error!");
	}
}
