package com.spring.aop;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test1 {

	@Test
	public void test1() {
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("com/spring/aop/beans.xml");
		//MyTarget proxyObject=applicationContext.getBean(MyTarget.class);//getBean实际获得的是子类对象
		MyInterface proxyObject=applicationContext.getBean(MyInterface.class);//如果使用接口实现方式,则需要使用接口对象代理调用方法
		proxyObject.show();
		proxyObject.show("hi");
	}
	
	@Test
	public void test2() {
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("com/spring/aop/beans.xml");
		MyInterface proxyObject=applicationContext.getBean(MyInterface.class);//如果使用接口实现方式,则需要使用接口对象代理调用方法
		proxyObject.show("hi");
	}
	
	@Test
	public void test3() throws Exception {
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("com/spring/aop/beans.xml");
		MyInterface proxyObject=applicationContext.getBean(MyInterface.class);//如果使用接口实现方式,则需要使用接口对象代理调用方法
		proxyObject.show(16);
	}
	
}
