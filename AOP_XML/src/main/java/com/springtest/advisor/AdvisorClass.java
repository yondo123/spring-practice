package com.springtest.advisor;

import org.aspectj.lang.ProceedingJoinPoint;

public class AdvisorClass {
	//before
	public void advBefore() {
		System.out.println("Advisor:: Before Method");
	}
	
	//after
	public void advAfter() {
		System.out.println("Advisor:: After Method");
	}

	//around
	public Object aroundMethod(ProceedingJoinPoint joinpoint) throws Throwable {
		Object text = joinpoint.proceed();
		System.out.println("around Method!");
		// 원래 메소드 호출
		return text;
	}

	//after return
	public void advAfterReturn() {
		System.out.println("Advisor :: After Returning Method");
	}

	//after throwing (error)
	public void throwsMethod() {
		System.out.println("Advisor :: Error!!");
	}
}
