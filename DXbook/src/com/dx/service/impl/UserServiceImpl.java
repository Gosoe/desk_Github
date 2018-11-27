package com.dx.service.impl;

import java.util.List;

import com.dx.dao.UserDAO;
import com.dx.dao.impl.UserDAOImpl;
import com.dx.pojo.Page;
import com.dx.pojo.User;
import com.dx.service.UserService;

public class UserServiceImpl implements UserService {

	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<User> selectAllUser(Page page) {
		// TODO Auto-generated method stub
		UserDAO userDAO=new UserDAOImpl();
		return userDAO.selectAllUser(page);
	}

	@Override
	public User getUserByAccount(String account) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void rechargeMoney(float allmoney, int userId) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteUserById(int userId) {
		// TODO Auto-generated method stub

	}

}
