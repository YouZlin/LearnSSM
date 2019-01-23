package com.spring.proxy.jdk;

public class MyTarget implements MyInterface{

	@Override
	public void show() {
		System.out.println("目标类的show方法");
	}

}
