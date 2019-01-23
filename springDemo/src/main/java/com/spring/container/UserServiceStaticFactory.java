package com.spring.container;

/**
 * 静态类的工厂模式
 */
public class UserServiceStaticFactory {
	public static UserService createUserService() {
		return new UserService();
	}
}
