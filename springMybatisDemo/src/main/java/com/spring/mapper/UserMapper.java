package com.spring.mapper;

import java.util.List;

import com.spring.pojo.User;

public interface UserMapper {
	List<User>select(User user);
	
}
