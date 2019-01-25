package com.spring.annotation;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test1 {

	@Test
	public void test1() {
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("com/spring/annotation/beans.xml");
		UserService userService=(UserService) applicationContext.getBean("userService");
		System.out.println(userService);
		
		AbstractApplicationContext abstractApplicationContext=(AbstractApplicationContext) applicationContext;
		abstractApplicationContext.destroy();
	}
}
