package com.spring.container;

/**
 * 使用工厂方式生产bean的对象
 * @author Administrator
 *
 */
public class UserServiceFactory {
	
	public UserService createUserService() {
		return new UserService();
	}

}
