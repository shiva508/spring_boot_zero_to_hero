package com.pool.config.aop.aopuser.afteradvice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(4)
public class AopUserAfterAdvice {

	@After("execution(* com.pool.service.aop.AopUserServiceImpl.getAllAopUsers(..))")
	public void afterAdviceFinally(JoinPoint joinPoint) {
		System.out.println("============================AFTER ADVICE================================");
		String method=joinPoint.getSignature().toShortString();
		System.out.println("method:"+method);
		System.out.println("============================AFTER ADVICE================================");
	}
}
