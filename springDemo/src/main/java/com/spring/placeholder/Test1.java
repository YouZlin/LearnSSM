package com.spring.placeholder;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test1 {
	@Test
	public void test1() throws SQLException{
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("com/spring/placeholder/beans.xml");
		
		DataSource dataSource=(DataSource) applicationContext.getBean("dataSource");
		
		System.out.println(dataSource.getConnection());
	}
}
