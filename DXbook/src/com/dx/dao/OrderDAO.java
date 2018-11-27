package com.dx.dao;

import java.util.List;

import com.dx.pojo.Order;

public interface OrderDAO {
	//添加订单
	public void addOrder(Order order);
	
	//已付款
	public List listMyshopping(int userId);
	//签收
	public void receivedBook(int orderId);
	//发货
	public void sendBook(int orderId);
	//通过bookId获取订单对象orderList
	public List getOrderBybookId(int bookId);
}
