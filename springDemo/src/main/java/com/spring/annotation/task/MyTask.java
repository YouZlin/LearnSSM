package com.spring.annotation.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class MyTask {

	@Scheduled(fixedRate=5000)
	public void doTask() throws InterruptedException {
		System.out.println("doTask被执行了,当前时间是:"+System.currentTimeMillis());
	}
}
