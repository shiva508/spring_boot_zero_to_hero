package com.pool.config.aop.aopuser.afterreturn;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.pool.model.aop.AopUser;

@Component
@Order(3)
@Aspect
public class AopUserAfterReturn {

	@AfterReturning(pointcut = "com.pool.config.aop.aopuser.expression.AopUserAspectCommonExpressions.afterReturningAopUserPointcut()", returning = "aopUsers")
	public void afterReturningAopUser(JoinPoint joinPoint, List<AopUser> aopUsers) {
		System.out.println("============================AFTER RETURN ADVICE================================");
		String method = joinPoint.getSignature().toShortString();
		System.out.println("method:" + method);

		aopUsers.forEach(data -> {
			System.out.println(data.getUserId() + ":::::" + data.getUserName().toUpperCase());
		});

		System.out.println("============================AFTER RETURN ADVICE================================");
	}
}
