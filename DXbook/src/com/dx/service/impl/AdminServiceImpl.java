package com.dx.service.impl;

import com.dx.dao.AdminDAO;
import com.dx.dao.impl.AdminDAOImpl;
import com.dx.pojo.Admin;
import com.dx.service.AdminService;

public class AdminServiceImpl implements AdminService {

	@Override
	public Admin getAdminByAccount(String account) {
		AdminDAO adminDAO=new AdminDAOImpl();
		return adminDAO.getAdminByAccount(account);
	}

}
