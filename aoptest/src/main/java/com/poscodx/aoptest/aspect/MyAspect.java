package com.poscodx.aoptest.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;


@Component
@Aspect
public class MyAspect {
	
	@Before("execution(public com.poscodx.aoptest.vo.ProductVo com.poscodx.aoptest.service.ProductService.find(String))")  // 메소드가 실행하기 전에 해당 메소드를 실행 - pointcut 지정
	public void adviceBefore() {
		System.out.println("--- Before Advice ---");
	}
	
	@After("execution(com.poscodx.aoptest.vo.ProductVo com.poscodx.aoptest.service.ProductService.find(String))")
	public void adviceAfter() {
		System.out.println("--- After Advice ---");
	}
	
	@AfterReturning("execution(* com.poscodx.aoptest.service.ProductService.find(..))")  // turn, parameter 생략 
	public void adviceAfterReturning() {
		System.out.println("--- AfterReturning Advice ---");
	}
	
	
}
