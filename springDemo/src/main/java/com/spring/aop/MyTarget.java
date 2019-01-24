package com.spring.aop;

@MyAnnotation
public class MyTarget implements MyInterface{

	@Override
	@MyAnnotation2
	public void show() {
		System.out.println("MyTarget的show()方法执行了");
		
//		show("hi");
	}
	
	@Override
	public String show(String str) {
		System.out.println("MyTarget的show(String)方法执行了");
		
		return str+" AOP";
	}
	
	@Override
	public void show(Integer age) throws Exception {
		System.out.println("MyTarget的show(String)方法执行了");
		throw new Exception();
	}

}
