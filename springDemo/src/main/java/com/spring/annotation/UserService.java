package com.spring.annotation;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

//@Component("userService")
@Service
public class UserService {//使用注解把类标注为bean
	//默认beanName是 userService
	
	//实现spring对注解支持需要配置xml文件
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
}
