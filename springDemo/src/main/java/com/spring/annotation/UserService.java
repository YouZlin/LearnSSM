package com.spring.annotation;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

//@Component("userService")
@Service
public class UserService {//使用注解把类标注为bean
	//默认beanName是 userService
	
	//实现spring对注解支持默认是关闭的,需要配置xml文件
	//配置需要使用注解的包路径,包路径可以使用,隔开配置多个包
	//  	<context:component-scan base-package="com.spring.annotation"></context:component-scan>

	@PostConstruct
	public void init() {
		System.out.println("init方法执行了");
	}
	
	@PreDestroy
	public void destory() {
		System.out.println("destory方法执行了");
	}
	
	@Autowired //可以标记在set方法上,通过反射执行set方法注入
	private IDao<User> userDao;
	public IDao<User> getUserDao() {
		return userDao;
	}
	public void setUserDao(IDao<User> userDao) {
		this.userDao = userDao;
	}
	
	@Autowired
	private ApplicationContext applicationContext;
	public ApplicationContext getApplicationContext() {
		return applicationContext;
	}
	public void setApplicationContext(ApplicationContext applicationContext) {
		this.applicationContext = applicationContext;
	}
	
	@Value("hi annotation")
	private String testField;
	public String getTestField() {
		return testField;
	}
	public void setTestField(String testField) {
		this.testField = testField;
	}
	
}
