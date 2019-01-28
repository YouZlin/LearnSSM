package com.spring.web.resolver;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

/**
 * 异常解析器
 *
 */
@Component
public class MyExceptionResolver implements HandlerExceptionResolver{

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		
		//实际项目中使用日志记录异常信息
		ex.printStackTrace();
		
		
		if (request.getHeader("X-Requested-With")!=null) {//ajax请求
			try {
				response.getWriter().print("{\"status\":\"error\",\"data\":\"服务器出错了\"}");
			} catch (IOException e) {
				//实际项目中使用日志记录异常信息
				e.printStackTrace();
			}
			return new ModelAndView();//创建空对象,SpringMVC才会认为已经生成响应,如果为null不会认为生成响应
		}else {//普通请求
			ModelAndView modelAndView=new ModelAndView("500");
			return modelAndView;
		}
		
		
	}

}
