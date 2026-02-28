package com.service;

import com.dao.UserDao;
import com.dto.UserDTO;

public class UserService {
	private UserDao userDao;
	public UserService() {
		userDao=new UserDao();
	}
	public boolean createUser(UserDTO user) {
		return userDao.insert(user); 
	}
	public UserDTO getUserById(int id) {
		return userDao.getById(id);
	}
	public boolean updateUser(UserDTO user,int id) {
		return userDao.update(user, id);
	}
	public boolean deleteUserById(int id) {
		return userDao.deleteById(id);
	}
}
