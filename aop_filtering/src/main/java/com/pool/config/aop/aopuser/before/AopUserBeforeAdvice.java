package com.pool.config.aop.aopuser.before;


import java.util.List;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.pool.model.aop.AopUser;


@Aspect
@Component
public class AopUserBeforeAdvice {
	@Before("execution(public void called())")
	public void beforeCallMethod() {
		System.out.println("I was called");
	}
	
	@Before("execution(* getAllAopUsers())")
	public void beforeCallMethodModifier() {
		System.out.println("I was called on other");
	}
	
	@Before("execution(public void com.pool.service.aop.AopUserServiceImpl.called())")
	public void beforeCallMethodModifierFullyQualified() {
		System.out.println("I was called on fully qualified");
	}
	
	@Before("execution(public * com.pool.service.aop.AopUserServiceImpl.getAllAopUsers())")
	public void beforeCallMethodModifierFullyQualifiedObject() {
		System.out.println("I was called on fully qualified Object");
	}
	
	@Before("execution(public * com.pool.service.aop.AopUserServiceImpl.getAll*())")
	public void beforeCallMethodModifierFullyQualifiedObjectWildcard() {
		System.out.println("I was called on fully qualified Object Wildcard");
	}
	
	@Before("execution(public java.util.List<com.pool.model.aop.AopUser> com.pool.service.aop.AopUserServiceImpl.getAllAopUsers())")
	public void withReturnTypeObject() {
		System.out.println("I was called on fully qualified Object Return type object");
	}
	
	@Before("execution(public com.pool.model.aop.AopUser save(com.pool.model.aop.AopUser))")
	public void withInputParamsFullyQualified() {
		System.out.println("WITH FULLY QUALIFIED INPUT");
	}
	
	@Before("execution(* com.pool.service.aop.*.*(..))")
	public void anyMatchInsidePackage() {
		System.out.println("INSIDE PACKAGE");
	}
}


