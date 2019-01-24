package com.spring.db;

public class UserService {
	
	private UserDao userDao;
	public UserDao getUserDao() {
		return userDao;
	}
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	public void insert(User user) {
		this.userDao.insert(user);
	}
	
	 public User selectById(Long id) {
		return this.userDao.selectById(id);
	 }
}
