package com.dx.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dx.dao.OrderDAO;
import com.dx.pojo.Order;
import com.dx.tools.DBUtil;

public class OrderDAOImpl implements OrderDAO {

	@Override
	public void addOrder(Order order) {
		// TODO Auto-generated method stub
		Connection conn=DBUtil.getConn();
		String sql="INSERT INTO `order` VALUES(null,?,?,?,?,default,default,'1')";
		DBUtil.excuteSql(sql, order.getUserId(),order.getBookId(),order.getCount(),order.getDateTime());
		DBUtil.closeConnection();
	}

	@Override
	public List listMyshopping(int userId) {
		// TODO Auto-generated method stub
		List<Order> orderList=new ArrayList<Order>();
		try {
			Connection conn=DBUtil.getConn();
			String sql="select o.*,b.name from `order` o,book b where o.bookId=b.bookId and o.userId=? and o.isPaid='1'";
			ResultSet rs=DBUtil.excuteQuery(sql, userId);
			while(rs.next()){
				Order order=new Order();
				order.setOrderId(rs.getInt(1));
				order.setUserId(rs.getInt(2));
				order.setBookId(rs.getInt(3));
				order.setCount(rs.getInt(4));
				order.setDateTime(rs.getString(5));
				order.setIsDeliveried(rs.getString(6));
				order.setIsAccepted(rs.getString(7));
				order.setIsPaid(rs.getString(8));
				order.setBookName(rs.getString(9));
				orderList.add(order);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.closeConnection();
		}
		return orderList;
	}
	//签收
	@Override
	public void receivedBook(int orderId) {
		// TODO Auto-generated method stub
		Connection conn=DBUtil.getConn();
		String sql="update `order` set isAccepted='1' where orderId=?";
		DBUtil.excuteSql(sql, orderId);
		DBUtil.closeConnection();
	}
	//已发货
	public void sendBook(int orderId){
		Connection conn=DBUtil.getConn();
		String sql="update `order` set isDeliveried='1' where orderId=?";
		DBUtil.excuteSql(sql, orderId);
		DBUtil.closeConnection();
	}
	
	//通过bookId获取Order对象
	public List getOrderBybookId(int bookId){
		List<Order> orderList=new ArrayList<Order>();
		try{
			Connection conn=DBUtil.getConn();
			String sql="select o.*,b.name from `order` o,book b where o.bookId=b.bookId and o.bookId=? and o.isPaid='1'";
			ResultSet rs=DBUtil.excuteQuery(sql, bookId);
			while(rs.next()){
				Order order=new Order();
				order.setOrderId(rs.getInt(1));
				order.setUserId(rs.getInt(2));
				order.setBookId(rs.getInt(3));
				order.setCount(rs.getInt(4));
				order.setDateTime(rs.getString(5));
				order.setIsDeliveried(rs.getString(6));
				order.setIsAccepted(rs.getString(7));
				order.setIsPaid(rs.getString(8));
				order.setBookName(rs.getString(9));
				orderList.add(order);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally{
		DBUtil.closeConnection();
	}
		return orderList;
	}
	
}
