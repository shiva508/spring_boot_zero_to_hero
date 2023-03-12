package com.pool.config.aop.aopuser.around;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Aspect
@Slf4j
public class AopUserAround {
	
	private Logger logger = LoggerFactory.getLogger(AopUserAround.class);

	@Around("execution(* com.pool.service.aop.AopUserServiceImpl.getAllAopUsers(..))")
	public Object aopUserAroundAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		Long startTime = System.currentTimeMillis();
		logger.info("Before Method called");
		Object processedData = proceedingJoinPoint.proceed();
		Long endTime = System.currentTimeMillis();
		logger.info("endTime:" + endTime + "-startTime:" + startTime);
		Long timeTaken = endTime - startTime;
		logger.info("time taken :{}", timeTaken);
		return processedData;
	}
	
}
