package com.spring.container;

public class User {
	private String name;
	private Integer age;
	/**
	 * 无参构造函数
	 */
	public User() {
	}
	/**
	 * 有参构造函数
	 */
	public User(String name, Integer age) {
		this.name = name;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	
}
