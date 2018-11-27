package com.dx.dao;

import com.dx.pojo.Admin;

public interface AdminDAO {
	//通过账号获取admin对象
	public Admin getAdminByAccount(String account);
	
	//通过adminId给账户充值
	public void rechargeMoney(float allmoney,int adminId);
	
	
}
