package com.spring.task;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test1 {

	@Test
	public void test1() throws InterruptedException {
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("com/spring/task/beans.xml");
		Thread.sleep(100000);
	}
}
