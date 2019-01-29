package com.ssm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssm.mapper.UserMapper;
import com.ssm.pojo.User;

@Service
public class UserService {
	
	@Autowired
	private UserMapper userMapper;
	
	
	public int  register(User user) {
		return userMapper.insert(user);
	}
}
