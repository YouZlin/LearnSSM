package com.spring.web.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.spring.pojo.Role;
import com.spring.pojo.User;

@Controller
@RequestMapping(value="/user")//在类上执行父路径
public class UserController {
	
	//后缀加上.do代表交给handler去处理,不加也没有关系
	@RequestMapping(value="/register.do",method=RequestMethod.GET)
	public String registerPage() {
		return "register";
	}
	
	@RequestMapping(value="/register.do",method=RequestMethod.POST)
	public String registerSubmit(String email,String password) {
		
		//执行注册的业务逻辑
		return "registerSuccess";
	}
	
	@RequestMapping(value="/edit.do",method=RequestMethod.GET)
	public ModelAndView editPage(User user) {//使用Sprin的form标签时handler需要传入pojo对象
		//当成从数据库中获得所有角色列表
		List<Role>allRoleList=new ArrayList<Role>();
		allRoleList.add(new Role(1L,"超级管理员"));
		allRoleList.add(new Role(2L,"系统管理员"));
		allRoleList.add(new Role(3L,"辅导老师"));
		allRoleList.add(new Role(4L,"班主任"));
		
		user.setBirthday(new Date());
		user.setEmail("a@b.c");
		user.setName("李思思");
		user.setId(1L);
		//用户拥有的角色
		List<Role>roleList=new ArrayList<Role>();
		roleList.add(new Role(2L,"系统管理员"));
		roleList.add(new Role(3L,"辅导老师"));
		
		user.setRoleList(roleList);
		
		ModelAndView modelAndView=new ModelAndView("edit");
//		modelAndView.addObject("user", user);//内部自动添加对象,可以不需要该方法
		modelAndView.addObject("allRoleList", allRoleList);
		
		return modelAndView;
	}
	
	@RequestMapping(value="/edit.do",method=RequestMethod.POST)
	public ModelAndView editSubmit(Long[]roleList,@Validated User user,BindingResult bindingResult) {//提交数据格式错误,需要紧跟着添加BindingResult
//		若使用@Validated校验器校验时,需要在对象类(当前为User)需要的字段添加下列注解
//		@NotEmpty 此字段不能为null，也不能为空字符串
//		@Length 可以指定字符串的最小、最大长度
//		@Min 指定数值的最小值
//		@Max 指定数值的最大值
//		@Range 指定数值的范围
//		@Size 指定数组、集合的元素范围
//		@AssertTrue 断定boolean值为true
//		@AssertFalse 
//		@Email 指定字符串符合email格式
//		@Pattern 字符串符合指定的正则表达式

		if(bindingResult.getFieldError("email")!=null) {//校验失败后,数据将填充到BiningResult
			return editPage(user);
		}
		
		System.out.println("editSubmit.roleList ====> "+Arrays.toString(roleList));//表单信息获得角色的值
		System.out.println("editSubmit ====> "+user);
		ModelAndView modelAndView=new ModelAndView("editSuccess");
		return modelAndView;
	}
}
