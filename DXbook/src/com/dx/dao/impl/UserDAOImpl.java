package com.dx.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dx.dao.UserDAO;
import com.dx.pojo.Page;
import com.dx.pojo.User;
import com.dx.tools.DBUtil;

public class UserDAOImpl implements UserDAO {

	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub
		Connection conn=DBUtil.getConn();
		String sql="insert into user values(null,?,?,?,?,?,?,?,?,?,?)";
		DBUtil.excuteSql(sql, user.getAccount(),user.getPassword(),user.getName(),user.getSex(),user.getIDCard(),user.getPostAddress(),user.getPostCode(),user.getEmail(),user.getMoney(),user.getIsAdmin());
		DBUtil.closeConnection();
	}
	
	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		
	}

	public int getUserCount(){
		int count=0;
		try {
			Connection conn=DBUtil.getConn();
			String sql="select count(userId) from user";
			ResultSet rs=DBUtil.excuteQuery(sql);
			while(rs.next()){
				count=rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.closeConnection();
		}
		return count;
	}
	
	@Override
	public List<User> selectAllUser(Page page) {
		// TODO Auto-generated method stub
		List<User> userList=new ArrayList<User>();
		try {
			Connection conn=DBUtil.getConn();
			String sql="select * from user limit ?,?";
			ResultSet rs=DBUtil.excuteQuery(sql, (page.getCurrentPage()-1)*page.getPageSize(),page.getPageSize());
			while(rs.next()){
				User user=new User();
				user.setUserId(rs.getInt(1));
				user.setAccount(rs.getString(2));
				user.setPassword(rs.getString(3));
				user.setName(rs.getString(4));
				user.setSex(rs.getString(5));
				user.setIDCard(rs.getString(6));
				user.setPostAddress(rs.getString(7));
				user.setPostCode(rs.getString(8));
				user.setEmail(rs.getString(9));
				user.setMoney(rs.getFloat(10));
				user.setIsAdmin(rs.getString(11));
				userList.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.closeConnection();
		}
		return userList;
	}

	@Override
	public User getUserByAccount(String account) {
		// TODO Auto-generated method stub
		User user=new User();
		try {
			Connection conn=DBUtil.getConn();
			String sql="select * from user where account=?";
			ResultSet rs=DBUtil.excuteQuery(sql, account);
			while(rs.next()){
				user.setUserId(rs.getInt(1));
				user.setAccount(rs.getString(2));
				user.setPassword(rs.getString(3));
				user.setName(rs.getString(4));
				user.setSex(rs.getString(5));
				user.setIDCard(rs.getString(6));
				user.setPostAddress(rs.getString(7));
				user.setPostCode(rs.getString(8));
				user.setEmail(rs.getString(9));
				user.setMoney(rs.getFloat(10));
				user.setIsAdmin(rs.getString(11));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.closeConnection();
		}
		return user;
	}

	public User getUserById(int userId){
		User user=new User();
		try {
			Connection conn=DBUtil.getConn();
			String sql="select * from user where userId=?";
			ResultSet rs=DBUtil.excuteQuery(sql, userId);
			while(rs.next()){
				user.setUserId(rs.getInt(1));
				user.setAccount(rs.getString(2));
				user.setPassword(rs.getString(3));
				user.setName(rs.getString(4));
				user.setSex(rs.getString(5));
				user.setIDCard(rs.getString(6));
				user.setPostAddress(rs.getString(7));
				user.setPostCode(rs.getString(8));
				user.setEmail(rs.getString(9));
				user.setMoney(rs.getFloat(10));
				user.setIsAdmin(rs.getString(11));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.closeConnection();
		}
		return user;
	}
	@Override
	public void rechargeMoney(float allmoney, int userId) {
		// TODO Auto-generated method stub
		Connection conn=DBUtil.getConn();
		String sql="update user set money=? where userId=?";
		DBUtil.excuteSql(sql, allmoney,userId);
		DBUtil.closeConnection();
	}

	@Override
	public void deleteUserById(int userId) {
		// TODO Auto-generated method stub
		Connection conn=DBUtil.getConn();
		String sql="delete from user where userId=?";
		DBUtil.excuteSql(sql, userId);
		DBUtil.closeConnection();
	}

}
