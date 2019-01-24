package com.spring.db;

public class User {
	
	/*
	 create table T_Users(
	 	id bigint primary key auto_increment,
	 	name varchar(100) not null,
	 	age int
	 );
	 */
	private Long id;
	private String name;
	private Integer age;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
