package com.pool.config.aop.aopuser.expression;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AopUserAspectCommonExpressions {
	@Pointcut("execution(* com.pool.service.aop.*.*(..))")
	public void aopUserPointCut() {
		System.out.println("POINT CUT EXPRESSION");
	}

	// getter pointcut

	@Pointcut("execution(* com.pool.service.aop.*.get*(..))")
	public void aopGetterPointCut() {
		System.out.println("Getter pointcut");
	}

	// setter pointcut
	@Pointcut("execution(* com.pool.service.aop.*.set*(..))")
	public void aopSetterPointCut() {
		System.out.println("SETTER POINT CUT");
	}

	// include package ............exclude set,get
	@Pointcut("aopUserPointCut() && !(aopGetterPointCut() || aopSetterPointCut())")
	public void aopAllowPackageNoSetterPointCut() {
		System.out.println("ALLOW PACKAGE NO SETTERS AND GETTERS");
	}
	@Pointcut("execution(* com.pool.service.aop.AopUserServiceImpl.getAllAopUsers(..))")
	public void afterReturningAopUserPointcut() {
		
	}

}
