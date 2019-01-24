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
	
	@Test//myAfterReturnning
	public void test2() {
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("com/spring/aop/beans.xml");
		MyInterface proxyObject=applicationContext.getBean(MyInterface.class);//如果使用接口实现方式,则需要使用接口对象代理调用方法
		proxyObject.show("hi");
	}
	
	@Test//myAfterThrowing
	public void test3() throws Exception {
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("com/spring/aop/beans.xml");
		MyInterface proxyObject=applicationContext.getBean(MyInterface.class);//如果使用接口实现方式,则需要使用接口对象代理调用方法
		proxyObject.show(16);
	}
	
	@Test//myAfter,在最后面执行,如此处在myAfterReturnning之后才执行myAfter
	public void test4() {
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("com/spring/aop/beans.xml");
		MyInterface proxyObject=applicationContext.getBean(MyInterface.class);//如果使用接口实现方式,则需要使用接口对象代理调用方法
		proxyObject.show("hi");
	}
	
	@Test//myAround,实现了多个效果,处理效果在最先和最后位置
	public void test5() {
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("com/spring/aop/beans.xml");
		MyInterface proxyObject=applicationContext.getBean(MyInterface.class);//如果使用接口实现方式,则需要使用接口对象代理调用方法
		proxyObject.show("hi");
	}
	
}
