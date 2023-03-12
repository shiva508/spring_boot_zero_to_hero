package com.pool.config.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

//@Aspect
public class MyAopUtils {
	@Pointcut("execution(* com.pool.service.*.*(..))")
	public void forServiceLayer() {
		System.out.println("POINT CUT");
	}
	@Pointcut("execution(* com.pool.service.*.get*(..))")
	public void forGetters() {
		System.out.println("GETTER POINT CUT");
	}
	@Pointcut("execution(* com.pool.service.*.set*(..))")
	public void forSetters() {
		System.out.println("SETTER POINT CUT");
	}
	@Pointcut("forServiceLayer()&& !(forSetters()||forGetters()))")
	public void onlyServicePackage()
	{
		System.out.println("ONLY PACKAGE");
		
	}
}
