package com.pool.config.aop.aopuser.afterthrowing;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(4)
public class AopUserAfterThrowing {
	@AfterThrowing(pointcut = "com.pool.config.aop.aopuser.expression.AopUserAspectCommonExpressions.afterReturningAopUserPointcut()",throwing  ="throwable")
	public void whenExceptionThorwn(JoinPoint joinPoint,Throwable throwable) {
		System.out.println("============================AFTER RETURN ADVICE THROWBLE================================");
		String method=joinPoint.getSignature().toShortString();
		System.out.println("method:"+method);
		System.out.println("throwable:"+throwable);
		System.out.println("============================AFTER RETURN ADVICE THROWBLE================================");
	}
}
