package com.exemple.comtrade.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
	
	private Logger myLogger = Logger.getLogger(getClass().getName());
	
	@Pointcut("execution(* com.example.comtrade.controller.*.*(..))")
	private void forControllerPackage() {
		
		
	}
	
	@Pointcut("execution(* com.example.comtrade.service.*.*(..))")
	private void forControllerService() {
		
		
	}
	
	@Pointcut("execution(* com.example.comtrade.repository.*.*(..))")
	private void forControllerRepository() {
		
		
	}
	 
	@Pointcut("forControllerRepository() || forControllerService() || forControllerPackage()")
	private void forApp() {
		
	}
	
	
	
	
	@Before("forApp()")
	public void before(JoinPoint joinPoint) {
		
		String theMethod = joinPoint.getSignature().toShortString();
		myLogger.info("=====>> in @Before: calling method: " +theMethod);
		
		
		Object[] args = joinPoint.getArgs();
		
		for(Object tempArg: args) {
			myLogger.info("=====>> argument: " + tempArg);
		}
		
		
	}
	
	
	@AfterReturning(
			pointcut="forApp()",
			returning="result"	
			)
	public void afterReturning(JoinPoint joinPoint, Object result) {
		
		String theMethod = joinPoint.getSignature().toShortString();
		myLogger.info("=====>> in @AfterReturning: from method: " +theMethod);
		
		myLogger.info("====>> result: " + result);
		
	}
	
	

}
