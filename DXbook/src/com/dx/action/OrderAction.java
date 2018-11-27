package com.dx.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.dx.dao.BookDAO;
import com.dx.dao.OrderDAO;
import com.dx.dao.impl.BookDAOImpl;
import com.dx.dao.impl.OrderDAOImpl;
import com.dx.pojo.Book;
import com.dx.pojo.Order;
import com.dx.pojo.User;
import com.opensymphony.xwork2.ActionSupport;

public class OrderAction extends ActionSupport{
	private Order order;
	private User user;
	private Book book;
	private List<Order> orderList;
	public HttpServletRequest request;
	public HttpSession session;
	
	
	
	public String myShoppingHistory(){
		request=ServletActionContext.getRequest();
		session=request.getSession();
		
		user=new User();
		user=(User)session.getAttribute("user");
		OrderDAO orderDAO=new OrderDAOImpl();
		orderList=new ArrayList<Order>();
		orderList=orderDAO.listMyshopping(user.getUserId());
		return "myShoppingHistory.jsp";
	}
	//签收
	public String receivedBook(){
		OrderDAO orderDAO=new OrderDAOImpl();
		orderDAO.receivedBook(order.getOrderId());
		return "listMyBought";
	}
	
	public String myOrder(){
		request=ServletActionContext.getRequest();
		session=request.getSession();
		
		user=new User();
		book=new Book();
		user=(User)session.getAttribute("user");
		BookDAO bookDAO=new BookDAOImpl();
		//获取该用户被标记了isSold='1'的书   //有bug（如果有多个订单呢？？？）
		book=bookDAO.getOrderBook(user.getUserId());
		orderList=new ArrayList<Order>();
		OrderDAO orderDAO=new OrderDAOImpl();
		//通过bookId获取
		orderList=orderDAO.getOrderBybookId(book.getBookId());
		return "myOrder.jsp";
	}
	
	//发货
	public String sendBook(){
		OrderDAO orderDAO=new OrderDAOImpl();
		orderDAO.sendBook(order.getOrderId());
		return "listMyOrder";
	}
	
	
	
	
	
	
	
	
	//get/set
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public List<Order> getOrderList() {
		return orderList;
	}
	public void setOrderList(List<Order> orderList) {
		this.orderList = orderList;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public HttpServletRequest getRequest() {
		return request;
	}
	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}
	public HttpSession getSession() {
		return session;
	}
	public void setSession(HttpSession session) {
		this.session = session;
	}
	
	
	
}
