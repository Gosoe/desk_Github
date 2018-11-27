package com.dx.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.dx.dao.AdminDAO;
import com.dx.pojo.Admin;
import com.dx.tools.DBUtil;

public class AdminDAOImpl implements AdminDAO {

	@Override
	public Admin getAdminByAccount(String account) {
		Admin admin=null;
		try {
			Connection conn=DBUtil.getConn();
			String sql="select * from admin where account=?";
			ResultSet rs=DBUtil.excuteQuery(sql, account);
			while(rs.next()){
				admin=new Admin();
				admin.setAdminId(rs.getInt(1));
				admin.setAccount(rs.getString(2));
				admin.setPassword(rs.getString(3));
				admin.setName(rs.getString(4));
				admin.setSex(rs.getString(5));
				admin.setIDCard(rs.getString(6));
				admin.setPostAddress(rs.getString(7));
				admin.setPostCode(rs.getString(8));
				admin.setEmail(rs.getString(9));
				admin.setMoney(rs.getFloat(10));
				admin.setIsAdmin(rs.getString(11));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.closeConnection();
		}
		return admin;
	}

	@Override
	public void rechargeMoney(float allmoney,int adminId) {
		// TODO Auto-generated method stub
		Connection conn=DBUtil.getConn();
		String sql="update admin set money=? where adminId=?";
		DBUtil.excuteSql(sql, allmoney,adminId);
		DBUtil.closeConnection();
	}
	
	
}
