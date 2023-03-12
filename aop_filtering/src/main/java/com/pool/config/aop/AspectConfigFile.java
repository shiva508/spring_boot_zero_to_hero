package com.pool.config.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import com.pool.model.Product;

import javassist.bytecode.SignatureAttribute.MethodSignature;

//@Aspect
//@Configuration
//@ComponentScan(basePackages = { "com.pool" })
//@Order(3)
public class AspectConfigFile {
	/*
	 * Using pointcut we can create single pointcut once nad ca be reused many times
	 */
	@Pointcut("execution(* com.pool.service.*.*(..))")
	private void forServiceLayer() {
		System.out.println("POINT CUT");
	}

	@Pointcut("execution(* com.pool.service.*.get*(..))")
	private void forGetters() {
		System.out.println("GETTER POINT CUT");
	}

	@Pointcut("execution(* com.pool.service.*.set*(..))")
	private void forSetters() {
		System.out.println("SETTER POINT CUT");
	}

	/* @Before("execution(public void addProduct())") */
	/*
	 * @Before("execution(public void com.shiva.service.ProductServiveImpl.addProduct())"
	 * )
	 */
	/* @Before("execution(public void add*())") eturn type */
	/* @Before("execution(* add*())") */
	public void beforeAspectMethod() {
		System.out.println("Before Aspect method");
	}

	/* @Before("execution(* add*(com.shiva.model.Product))") */
	/* @Before("execution(* addProduct(..))") */
	/* @Before("execution(* com.shiva.service.*.*(..))") */
	public void beforAspectWithParam() {
		System.out.println("BEFORE WITH PARAMETERS");
	}

	/*
	 * Creating advice using pointcut:using method name of pointcut as advice param
	 */
	/* @Before("forServiceLayer()") */
	public void usingPointCut() {
		System.out.println("POINT CUTS");
	}

	/* @Before("forServiceLayer()") */
	public void usingPointCutAgain() {
		System.out.println("POINTCUT 2");
	}

	/*
	 * Combine pointcuts How do we apply multiple pointcut expressions to single
	 * advice??????? Execute advice based on condition
	 */
	@Pointcut("forServiceLayer()&& !(forSetters()||forGetters()))")
	public void onlyServicePackage() {
		System.out.println("ONLY PACKAGE");

	}

	@Before("onlyServicePackage()")
	public void adviceForOnlyServicePackage() {
		System.out.println("NO SETTER && GETTER ONLY");
	}

	/* Accessing the orguments passed in the method using JOINPOINT */
	//@Before("onlyServicePackage()")
	public void joinPointForMethods(JoinPoint thejoinPoint) {
		// get method signature
		MethodSignature signature = (MethodSignature) thejoinPoint.getSignature();
		// display
		System.out.println("===============================");
		System.out.println("Method SIGNTURE:" + signature);
		System.out.println("===============================");
		Object[] aors = thejoinPoint.getArgs();
		printMessage(aors);
	}
	
	public void printMessage(Object [] myObject) {
		for (Object obj : myObject) {
			if(obj instanceof Product) {
				Product product=(Product) obj;
				System.out.println(product.toString());
			}
			if(obj instanceof String) {
				System.out.println(obj.toString());
			}
			if(obj instanceof Integer) {
				System.out.println(obj.toString());
			}
		}
	}
}
