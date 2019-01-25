package com.spring.annotation.aop;

import org.springframework.stereotype.Component;

@Component //不属于web.service.dao层,使用@Component
public class MyTarget {
	public String show(String str) {
		System.out.println("show方法执行了");
		return "hi aop";
	}
}
