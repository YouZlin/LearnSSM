package com.spring.proxy.cglib;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

public class MyMethodInterceptor implements MethodInterceptor {

    private Object targetObject;

    public MyMethodInterceptor(Object targetObject) {
        this.targetObject = targetObject;
    }
	@Override
	public Object intercept(Object proxyObject, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
		System.out.println("预处理");
        Object returnValue = method.invoke(targetObject, args);
        System.out.println("后处理");
        return returnValue;
	}
}
