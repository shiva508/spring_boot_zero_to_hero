package com.pool.config.aop.aopuser.before.order;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class AopUserPointCutDeclarationOrder {
	
	@Before("com.pool.config.aop.aopuser.expression.AopUserAspectCommonExpressions.aopUserPointCut()")
	public void beforePointcutExpression() {
		System.out.println("BEFORE POINTCUT CALLED");
	}

	@Before("com.pool.config.aop.aopuser.expression.AopUserAspectCommonExpressions.aopAllowPackageNoSetterPointCut()")
	public void beforePointcutExpressionToSaveToSolar() {
		System.out.println("BEFORE POINTCUT CALLED-->SAVE TO SOLAR");
	}

}
