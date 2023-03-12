package com.pool.config.aop.aopuser.before.pointcut;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class AopUserPointCutDeclaration {

	@Before("com.pool.config.aop.aopuser.expression.AopUserAspectCommonExpressions.aopAllowPackageNoSetterPointCut()")
	public void logToSolarAsync() {
		System.out.println("LOG TO CLOUD ASYNC");
	}
}
