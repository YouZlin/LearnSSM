package com.spring.annotation.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component //不属于web.service.dao层,使用@Component
@Aspect	//切面方法,使用@Aspect
public class MyAspect {
	@Pointcut("execution(* com.spring.annotation.aop.*.*(..))")
	public void myPonitCut1() {
		
	}
	
	@Pointcut("execution(* com.spring.annotation.aop.*.show(..))")
	public void myPonitCut2() {
		
	}
	
	@Before(value = "execution(* com.spring.annotation.aop.MyTarget.*(..))")
	public void myBefore(JoinPoint joinPoint) {
		System.out.println("myBefore执行了");
	}
	
	@AfterReturning(pointcut="myPonitCut1()",returning="returnValue")
	public void myAfterReturning(JoinPoint joinPoint,Object returnValue) {
		System.out.println("myAfterReturning执行了,目标方法的返回值是:"+returnValue);
	}
	
	@AfterThrowing(pointcut="myPonitCut1()",throwing="exception")
	public void myAfterThrowing(JoinPoint joinPoint,Exception exception) {
		System.out.println("myAfterThrowing执行了,异常信息是:"+exception);
	}
	
	@After("myPonitCut1()")
	public void after(JoinPoint joinPoint) {
		System.out.println("after执行了");
	}
	
	@Around("myPonitCut1()")
	public Object myAround(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("myAround的预处理执行了");
		Object returnValue=joinPoint.proceed();
		System.out.println("myAround的后处理执行了");
		return  returnValue;
	}
}
