package com.dx.pojo;

public class Order {
	private int orderId;
	private int userId;
	private int bookId;
	private int count;
	private String dateTime;
	private String isDeliveried;
	private String isAccepted;
	private String isPaid;
	
	private String userName;
	private String bookName;
	public Order() {
		super();
	}
	
	public Order(int orderId, int userId, int bookId, int count, String dateTime, String isDeliveried,
			String isAccepted,String isPaid) { 
		super();
		this.orderId = orderId;
		this.userId = userId;
		this.bookId = bookId;
		this.count = count;
		this.dateTime = dateTime;
		this.isDeliveried = isDeliveried;
		this.isAccepted = isAccepted;
		this.isPaid=isPaid;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getDateTime() {
		return dateTime;
	}
	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}
	public String getIsDeliveried() {
		return isDeliveried;
	}
	public void setIsDeliveried(String isDeliveried) {
		this.isDeliveried = isDeliveried;
	}
	public String getIsAccepted() {
		return isAccepted;
	}
	public void setIsAccepted(String isAccepted) {
		this.isAccepted = isAccepted;
	}
	public String getIsPaid() {
		return isPaid;
	}
	public void setIsPaid(String isPaid) {
		this.isPaid = isPaid;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	
	
}
