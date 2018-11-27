package com.dx.dao;

import java.util.List;

import com.dx.pojo.Admin;
import com.dx.pojo.Page;
import com.dx.pojo.User;

public interface UserDAO {
	//增
	public void addUser(User user);
	//改
	public void updateUser(User user);
	
	//查
	//查询所有用户
	public List<User> selectAllUser(Page page);
	//通过用户名获取User对象 （详情）
	public User getUserByAccount(String account);
	//通过用户Id获取User对象 （详情）
	public User getUserById(int userId);
	//
	public int getUserCount();
	//通过adminId给账户充值
	public void rechargeMoney(float allmoney,int userId);
	
	public void deleteUserById(int userId);
	
}
