package com.spring.container;

import java.sql.SQLException;

import javax.sql.DataSource;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestBeans {

//	@Test
	public void TestBeans() {
		//读取配置文件信息,创建容器对象
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("com/spring/container/beans.xml");
		
		//获取java对象
		UserService user_1=applicationContext.getBean(UserService.class);
		UserService user_2=(UserService)applicationContext.getBean("userService");
		
		System.out.println(user_1);
		System.out.println(user_2);
	}
	
//	@Test
	public void TestBeans2() {
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("com/spring/container/beans.xml");
		UserService userService=(UserService) applicationContext.getBean("userService");
		
		System.out.println(userService.getUserDao());
	}
	
//	@Test
	public void TestConnectMysql() throws SQLException {
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("com/spring/container/beans.xml");
		DataSource ds=(DataSource) applicationContext.getBean("dataSource");
		
		System.out.println(ds.getConnection());
	}
	
//	@Test
	public void TestTeam(){
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("com/spring/container/beans.xml");
		Team team=(Team) applicationContext.getBean("team");
		System.out.println(team.getMembers());
	}
	
	@Test
	public void TestUser(){
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("com/spring/container/beans.xml");
		User user=(User) applicationContext.getBean("user");
		System.out.println(user.getName());
		System.out.println(user.getAge());
	}
	
}
