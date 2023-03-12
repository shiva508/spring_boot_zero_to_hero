package com.pool.config.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

//@Configuration
//@Aspect
//@Order(6)
public class MyAopAroundAdvice {
	// combination of before and after method is executed
	@Around("execution(* com.pool.service.OrganizationServiceImpl.getAllOrganizations(..))")
	public Object howlongdoseittook(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		String method = proceedingJoinPoint.getSignature().toShortString();
		System.out.println("ARound Method:" + method);
		long began = System.currentTimeMillis();

		Object result = proceedingJoinPoint.proceed();
		long end = System.currentTimeMillis();

		long duriation = end - began;
		System.out.println("TIME TAKEN:" + duriation);
		return result;
	}
}
