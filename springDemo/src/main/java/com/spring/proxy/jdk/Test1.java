package com.spring.proxy.jdk;

import java.lang.reflect.Proxy;

import org.junit.Test;

public class Test1 {
	
	@Test
	public void test1() {
		MyTarget myTarget=new MyTarget();
		MyInvocationHandler invocationHandler=new MyInvocationHandler(myTarget);
		//执行代理类处理
		MyInterface proxyObject=(MyInterface) Proxy.newProxyInstance(MyTarget.class.getClassLoader(), 
				MyTarget.class.getInterfaces(), invocationHandler);
		
		proxyObject.show();
		System.out.println("________________________________");
		String str=proxyObject.toString();
		System.out.println(str);
	}

}
