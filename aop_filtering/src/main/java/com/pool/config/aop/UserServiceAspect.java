package com.pool.config.aop;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

import com.pool.model.User;

//@Aspect
//@Configuration
public class UserServiceAspect {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Before("execution(* users*())")
	public void before(JoinPoint joinPoint) {
		logger.info(" Check for user access ");
		logger.info(" Allowed execution for {}", joinPoint.getThis());
	}
}
