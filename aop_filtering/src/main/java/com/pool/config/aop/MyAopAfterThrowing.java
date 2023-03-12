package com.pool.config.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

//@Aspect
//@Configuration
//@Order(4)
public class MyAopAfterThrowing {
	@AfterThrowing(pointcut = "execution(* com.pool.service.OrganizationServiceImpl.getAllOrganizations(..))", throwing = "theExe")
	public void afterThrowingFindOrganizationAdvice(JoinPoint joinPoint, Throwable theExe) {
		String method = joinPoint.getSignature().toShortString();
		System.out.println("METHOD:" + method);
		System.out.println("EXCEPTION" + ";" + theExe);

	}
}
