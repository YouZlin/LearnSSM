package com.spring.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyInvocationHandler implements InvocationHandler{
	private MyTarget myTarget;
	public MyInvocationHandler(MyTarget myTarget) {
		this.myTarget=myTarget;
	}
	@Override
	public Object invoke(Object proxyObject, Method method, Object[] args) throws Throwable {
		//TODO:预处理,检查权限等操作
		System.out.println("invoke进行预处理");
		Object returnObject=method.invoke(myTarget, args);//执行目标类的目标方法
		//TODO:执行后处理
		System.out.println("执行后处理");
		return returnObject;
	}

}
