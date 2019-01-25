package com.spring.resource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.UrlResource;


public class Test1 {
	
	@Test
	public void test1() throws IOException {
		ClassPathResource resource=new ClassPathResource("com/spring/resource/beans.xml");
		InputStream inputStream=resource.getInputStream();
		BufferedReader reader=new BufferedReader(new InputStreamReader(inputStream));
		String line=null;
		while((line=reader.readLine())!=null) {
			System.out.println(line);
		}
		reader.close();
	}
	
	@Test
	public void test2() throws IOException {
		//针对于系统文件的绝对路径
		FileSystemResource resource=new FileSystemResource("D:\\Eclipse\\eclipse-java-oxygen-3a-win32-x86_64\\git\\LearnSSM\\springDemo\\target\\classes\\com\\spring\\resource\\beans.xml");
		InputStream inputStream=resource.getInputStream();
		BufferedReader reader=new BufferedReader(new InputStreamReader(inputStream));
		String line=null;
		while((line=reader.readLine())!=null) {
			System.out.println(line);
		}
		reader.close();
	}
	
	@Test
	public void test3() throws IOException {
		UrlResource resource=new UrlResource("file:D:\\Eclipse\\eclipse-java-oxygen-3a-win32-x86_64\\git\\LearnSSM\\springDemo\\target\\classes\\com\\spring\\resource\\beans.xml");
		InputStream inputStream=resource.getInputStream();
		BufferedReader reader=new BufferedReader(new InputStreamReader(inputStream));
		String line=null;
		while((line=reader.readLine())!=null) {
			System.out.println(line);
		}
		reader.close();
	}
	
	@Test
	public void test4() {
		/*
		创建ApplicationContext时配置文件路径的处理方式：
		1 如果路径有classpath:前缀，则使用ClassPathResource表示
		2 如果路径是URL，则使用URLResource表示
		3 使用特定于ApplicationContext子类的方式表示，比如使用ClassPathXmlApplicationContext子类时，就使用ClassPathResource表示；使用FileSystemXmlApplicationContext子类时，就使用FileSystemResource表示
		 */
		ApplicationContext applicationContext=new FileSystemXmlApplicationContext("classpath:com/spring/resource/beans.xml");
		System.out.println(applicationContext);
	}
	
}
