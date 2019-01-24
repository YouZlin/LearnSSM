package com.spring.db;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test1 {

	@Test
	public void test1(){
		User user=new User();
		user.setName("张珊珊");
		user.setAge(18);
		
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("com/spring/db/beans.xml");
		UserService userService=(UserService) applicationContext.getBean("userService");
		
		userService.insert(user);
	}
	
	@Test
	public void test2(){
		long id=1;
		
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("com/spring/db/beans.xml");
		UserService userService=(UserService) applicationContext.getBean("userService");
		
		User user=userService.selectById(id);
		System.out.println("姓名:"+user.getName()+",年龄:"+user.getAge());
	}
}
