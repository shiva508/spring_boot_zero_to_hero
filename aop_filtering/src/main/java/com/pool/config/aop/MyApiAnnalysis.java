package com.pool.config.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

//@Aspect
//@Component
//@Order(2)
public class MyApiAnnalysis {
	@Before("com.pool.config.aop.MyAopUtils.onlyServicePackage()")
	public void adviceForCloud() {
		System.out.println("MY API ANNALYSYS ADVICE");
	}

}
