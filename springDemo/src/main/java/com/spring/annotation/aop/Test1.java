package com.spring.annotation.aop;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test1 {

	@Test
	public void test1() {
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("com/spring/annotation/aop/beans.xml");
		MyTarget proxyObject=(MyTarget) applicationContext.getBean("myTarget");
		proxyObject.show("hello");
	}
}
