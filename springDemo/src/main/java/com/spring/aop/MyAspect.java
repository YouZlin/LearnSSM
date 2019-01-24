package com.spring.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class MyAspect {

	public void myAfterReturnning(JoinPoint joinPoint,Object returnValue) {
		System.out.println("myAfterReturnning执行了,目标方法的返回值是:"+returnValue);
	}
	
	public void myAfterThrowing(JoinPoint joinPoint,Exception exception) {
		System.out.println("myAfterThrowing执行了,目标方法抛出的异常是:"+exception);
	}
	
	public void myAfter(JoinPoint joinPoint) {
		System.out.println("myAfter执行了");
	}
	
	public Object myAround(ProceedingJoinPoint joinPoint)throws Throwable {
		//很类似前面jdk代理中InvocationHandler的invoke
		System.out.println("myAround的预处理");
		Object returnValue=joinPoint.proceed();
		System.out.println("myAround的后处理");
		return returnValue;
	}
}
