package com.pool.config.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

//@Aspect
//@Configuration
//@Order(5)
public class MyAopAfterAdvice {
	@After("execution(* com.pool.service.*.*(..))")
	public void afterAdviceAllOrganization() {
		System.out.println("@AFTER:");
	}
}
