package com.spring.web.controller;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.pojo.User;

@Controller
public class TestController {
	
//	@RequestMapping("/test")
//	@RequestMapping(value= {"/test","/test2"})
	@RequestMapping(value= {"/test"},method=RequestMethod.GET)
	public String test(Integer age,String name,HttpServletRequest request) {
		System.out.println("age="+age+",name="+name);
		return "success";
	}
	
	//实现常用的servlet内部方法
	@RequestMapping("/test2.do")
	public String test2(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		String age=request.getParameter("age");
		System.out.println(age);
		/*
		 * response.getWriter().println();
		 * request.getRequestDispatcher("").forward(request, response);
		 */
		request.getRequestDispatcher("/WEB-INF/jsp/success.jsp").forward(request, response);
		return null;//已处理响应,不需要spring mvc去生成响应
		
//		return "success";
	}
	
	//实现之前servlet内部的操作
	@RequestMapping("/test3.do")
	public String test3() throws ServletException, IOException {
		ServletRequestAttributes requestAttributes=(ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		
		HttpServletRequest request=requestAttributes.getRequest();
		HttpServletResponse response=requestAttributes.getResponse();
		String age=request.getParameter("age");
		System.out.println(age);
		
		request.getRequestDispatcher("/WEB-INF/jsp/success.jsp").forward(request, response);
		return null;//已处理响应,不需要spring mvc去生成响应
		
//		return "success";
	}
	
	//参数的""和null值问题
	@RequestMapping("/test4.do")
	public String test4(@RequestParam(value="age",required=false)Integer age) {//required=false,允许参数为null
		System.out.println(age);
		return "success"; 
	}
	
	//获得请求头
	@RequestMapping("/test5.do")
	public String test5(@RequestHeader("Accept")String  accept) {//请求头消息不区分大小写
		System.out.println(accept);
		return "success"; 
	}

	//获得cookie
	@RequestMapping("/test6.do")
	public String test6(@CookieValue("JSESSIONID")String jsessionId) {//请求头消息不区分大小写
		System.out.println(jsessionId);
		return "success"; 
	}
	
	
	@InitBinder
	/**
	 * 进行时间的格式化
	 * @param binder
	 */
	protected void initBinder(WebDataBinder binder) {
	    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	    binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}
	
	//输入格式化的时间,转化成内部时间格式
	@RequestMapping("/test7.do")
	public String test7(@RequestParam("birthday")Date birthday) {
		System.out.println(birthday);
		return "success"; 
	}
	
	//自定义转换时间格式化
	@RequestMapping("/test8.do")
	public String test8(String birthday) throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		if (birthday!=null && birthday.length()>0) {
			System.out.println(dateFormat.parse(birthday));
		}
		
		return "success"; 
	}
	
	//使用POJO
	@RequestMapping("/test9.do")
	public String test9(@ModelAttribute()User user){
		System.out.println(user);
		return "success"; 
	}
	
	//使用Model
	@RequestMapping("/test10.do")
	public String test10(Model model) {
		model.addAttribute("name", "test");
		model.addAttribute("age", 12);//默认存放到request中
		return "success2"; 
	}
	
	//使用Model和POJO对象
	@RequestMapping("/test11.do")
	public String test11(User user,Model model) {//如果没有model对象,默认会创建
		user.setEmail("a@b.c");
		// ===>
		//等价于model.addAttribute("user", user);
		
		model.addAttribute("name", "test");
		model.addAttribute("age", 12);//默认存放到request中
		return "success2"; 
	}
	
	//使用ModelAndView
	@RequestMapping("/test12.do")
	public ModelAndView test12() {
		//与test11效果相同
		ModelAndView modelAndView=new ModelAndView("success2");
		modelAndView.addObject("name", "张珊珊");
		return modelAndView; 
	}
	
	//重定向
	@RequestMapping("/test13.do")
	public ModelAndView test13(RedirectAttributes redirectAttributes) {
		//与test11效果相同
		ModelAndView modelAndView=new ModelAndView("redirect:/test12.do");
		//modelAndView.addObject("name", "张珊珊1");//重定向此处传入参数无效
		redirectAttributes.addAttribute("name", "李思思");
		return modelAndView; 
	}
	
	//服务器内部转发
	@RequestMapping("/test14.do")
	public ModelAndView test14() {
		ModelAndView modelAndView=new ModelAndView("forward:/test11.do");
		return modelAndView; 
	}
	
	//响应json数据
	@RequestMapping("/test15.do")
	public @ResponseBody User test15() {//常用作响应的json数据
		User user=new User();
		user.setName("王武武");
		user.setEmail("a@b.c");
		user.setBirthday(new Date());//没有在User中定义日期格式化,获得的值将是long类型的
		return user;//spring返回时将pojo,list,map等对象自动转化成json格式
	}
	
	//无返回值
	@RequestMapping("/test16.do")
	public void test16(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {//常用作响应的json数据
		
//		response.setContentType("text/html;charset=UTF-8");//编码格式出错,需要在此处进行声明编码格式
//		response.getWriter().println("无返回值类型的响应");
	
		request.getRequestDispatcher("/WEB-INF/jsp/success.jsp").forward(request, response);//也可以重定向等servlet的操作
	
	}
	
	//拦截器
	@RequestMapping("/test17.do")
	public ModelAndView test17(){//常用作响应的json数据
		System.out.println("TestController的test17()方法执行了");
		return new ModelAndView("success3");
	}
	
	
	
	@RequestMapping(value="/upload.do",method=RequestMethod.GET)
	public ModelAndView uploadPage() {
		ModelAndView modelAndView=new ModelAndView("upload");
		return modelAndView;
	}
	
	@RequestMapping(value="/upload.do",method=RequestMethod.POST)
	public ModelAndView uploadSubmit(MultipartFile upfile) throws IllegalStateException, IOException {//此处的参数名upfile需要和向当前相关页面(即upload)里的<input type="file" />中name=upfile相同
		System.out.println(upfile.getContentType());
		System.out.println(upfile.getOriginalFilename());
		System.out.println(upfile.getSize());
		
		upfile.transferTo(new File("I:/"+UUID.randomUUID()+upfile.getOriginalFilename()));
		
		ModelAndView modelAndView=new ModelAndView("success");//转到其他页面代表成功
		
		return modelAndView;
	}

	//测试异常解析器
	@RequestMapping("/test18.do")
    public ModelAndView test18() {
        int i = 1 / 0;

        ModelAndView modelAndView = new ModelAndView("upload");
        return modelAndView;
    }

}
