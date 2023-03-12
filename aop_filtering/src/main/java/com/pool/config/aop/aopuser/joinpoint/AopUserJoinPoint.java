package com.pool.config.aop.aopuser.joinpoint;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.pool.model.aop.AopUser;

@Aspect
@Component
@Order(3)
public class AopUserJoinPoint {

	@Before("com.pool.config.aop.aopuser.expression.AopUserAspectCommonExpressions.aopUserPointCut()")
	public void joinPointIntegration(JoinPoint joinPoint) {
		System.out.println("====BEFORE ADVICE JOIN POINT=================");
		MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
		System.out.println("Method Signatures:" + methodSignature);

		Object[] objects = joinPoint.getArgs();

		for (Object tempObject : objects) {
			System.out.println(tempObject);
			if (tempObject instanceof AopUser) {
				AopUser aopUser = (AopUser) tempObject;
				System.out.println("=================" + aopUser.getUserName() + "=======================");
			}
		}
	}

}
