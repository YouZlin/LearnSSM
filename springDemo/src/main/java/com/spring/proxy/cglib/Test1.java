package com.spring.proxy.cglib;

import org.junit.Test;
import org.springframework.cglib.proxy.Enhancer;

public class Test1 {
	
	@Test
	public void test1() {

	    MyTarget targetObject = new MyTarget();
	    MyMethodInterceptor methodInterceptor = new MyMethodInterceptor(targetObject);
	    Enhancer enhancer = new Enhancer();
	    enhancer.setSuperclass(MyTarget.class);
	    enhancer.setCallback(methodInterceptor);

	    MyTarget proxyObject = (MyTarget) enhancer.create();
	    proxyObject.show();
	}

}
