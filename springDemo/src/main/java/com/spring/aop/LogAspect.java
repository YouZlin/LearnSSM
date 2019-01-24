package com.spring.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;

public class LogAspect {
	
	public void log(JoinPoint joinPoint) {
		//JoinPoint参数可访问目标对象,目标方法签名,目标方法参数等
		Object target=joinPoint.getTarget();
		Signature signature=joinPoint.getSignature();
		Object[]args=joinPoint.getArgs();
		
//		args[0]=null;//不影响,只是copy出来,获得参数
		
		System.out.println("记录日志");
	}
}
