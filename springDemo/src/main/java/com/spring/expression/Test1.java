package com.spring.expression;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test1 {

	@Test
	public void test1() {
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("com/spring/expression/beans.xml");
		User user=(User) applicationContext.getBean("user");
		System.out.println(user.getAge()+","+user.getPhones());
	}
}
