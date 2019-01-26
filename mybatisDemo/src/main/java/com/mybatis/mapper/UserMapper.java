package com.mybatis.mapper;

import java.util.List;

import com.mybatis.pojo.User;

public interface UserMapper {
	List<User>selectAll();//方法名和xml配置中的id要一致
	int insert(User user);
	int insert2(String name);
	int update(User user);
	int delete(Long id);
	int delete2(Long id);
	List<User> selectById(Long id);
	
	List<User> select(User user);//动态条件,有添加的参数作为查询条件
	
	List<User> select2(User user);//可重用片段
}
