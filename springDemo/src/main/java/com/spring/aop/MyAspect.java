package com.spring.aop;

import org.aspectj.lang.JoinPoint;

public class MyAspect {

	public void myAfterReturnning(JoinPoint joinPoint,Object returnValue) {
		System.out.println("myAfterReturnning执行了,目标方法的返回值是:"+returnValue);
	}
	
	public void myAfterThrowing(JoinPoint joinPoint,Exception exception) {
		System.out.println("myAfterThrowing执行了,目标方法抛出的异常是:"+exception);
	}
}
