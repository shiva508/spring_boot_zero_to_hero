package com.pool.config.aop;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import com.pool.model.Organization;

//@Aspect
//@Configuration
//@Order(4)
public class MyAopAfterReturn {
	@AfterReturning(pointcut = "execution(* com.pool.service.OrganizationServiceImpl.getAllOrganizations(..))", returning = "orgs")
	public void afeterReturningOrganizations(JoinPoint joinPoint, List<Organization> orgs) {
		String name = joinPoint.getSignature().toShortString();
		System.out.println("@AFTERRETURNING:");
		System.out.println("A" + name);
		System.out.println(orgs);
	}
}
