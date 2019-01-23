package com.spring.proxy.cglib;

import com.spring.proxy.jdk.MyInterface;

public class MyTarget implements MyInterface{

	@Override
	public void show() {
		System.out.println("目标类的show方法");
	}

}
