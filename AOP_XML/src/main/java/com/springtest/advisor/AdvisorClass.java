package com.springtest.advisor;

import org.aspectj.lang.ProceedingJoinPoint;

public class AdvisorClass {
	public void advBefore() {
		System.out.println("Advisor:: Before Method");
	}

	public void advAfter() {
		System.out.println("Advisor:: After Method");
	}

	// around : 해당 메소드의 before - after
	public Object aroundMethod(ProceedingJoinPoint joinpoint) throws Throwable {
		Object text = joinpoint.proceed();
		System.out.println("around Method!");
		// 원래 메소드 호출
		return text;
	}

	public void advAfterReturn() {
		System.out.println("Advisor :: After Returning Method");
	}

	public void throwsMethod() {
		System.out.println("Advisor :: Error!!");
	}
}
