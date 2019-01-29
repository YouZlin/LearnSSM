package com.ssm.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ssm.pojo.User;
import com.ssm.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/register.do",method=RequestMethod.GET)
	public ModelAndView registerPage(User user) {
		
		ModelAndView modelAndVie=new ModelAndView("register");
		return modelAndVie;
	}
	
	@RequestMapping(value="/register.do",method=RequestMethod.POST)
	public ModelAndView registerSubmit(@Valid User user,BindingResult bindingResult) {
		if (bindingResult.getFieldError("email")!=null
				||bindingResult.getFieldError("password")!=null) {
			return new ModelAndView("register");
		}
		userService.register(user);
		ModelAndView modelAndVie=new ModelAndView("registerSuccess");
		return modelAndVie;
	}
	
	
	@RequestMapping(value="/register2.do",method=RequestMethod.GET)
	public ModelAndView register2Page() {
		ModelAndView modelAndVie=new ModelAndView("register2");
		return modelAndVie;
	}
	
	@RequestMapping(value="/register2.do",method=RequestMethod.POST)
	public ModelAndView register2Submit(String email,String password,HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		
		if (email == null || !email.matches("^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$")) {
	        request.setAttribute("message", "请输入正确的电子邮箱");
	        request.getRequestDispatcher("/WEB-INF/jsp/register2.jsp").forward(request, response);
	        return null;
	    }
	    if (password == null || password.length() < 6) {
	        request.setAttribute("message", "密码长度至少6位");
	        request.getRequestDispatcher("/WEB-INF/jsp/register2.jsp").forward(request, response);
	        return null;
	    }
		User user =new  User();
		user.setEmail(email);
		user.setPassword(password);
		userService.register(user);
		ModelAndView modelAndVie=new ModelAndView("registerSuccess");
		return modelAndVie;
	}

}
