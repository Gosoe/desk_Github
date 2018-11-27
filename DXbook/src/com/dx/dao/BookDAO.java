package com.dx.dao;

import java.sql.SQLException;
import java.util.List;

import com.dx.pojo.Book;
import com.dx.pojo.Page;
import com.dx.pojo.User;

public interface BookDAO {
	//增
	public void upload(Book book);
	
	//改(DAO层将Book全改  如果要单独改动，只需在service或者action层设置相应的book属性)
	public void update(Book book);
	
	//查
	//查询所有图书(用户+管理员)
	public List<Book> selectAllUserBook(Page page);
	public int getAllUserBookCount();
	//通过id查询该id管理员的所有图书
	public List<Book> selectAdminBookById(Page page,int adminId);
	public int getAdminBookCount(int adminId);
	//通过id查询该id用户的所有图书
	public List<Book> selectUserBookById(Page page,int userId);
	public int getUserBookCount(int userId);
	//通过id查询图书详情
	public Book selectBookDetailById(int bookId);
	
	//删
	public void deleteBookById(int bookId);
	
	//通过id获取Book对象
	public Book getBookById(int bookId);
	
	//主页所有图书
	public List<Book> selectAllBook(Page page);
	public int getAllBookCount();
	//搜索的所欲图书
	public List<Book> selectAllSearchBook(Page page,String bookName);
	public int getAllSearchBookCount(String bookName);
	
	//买书
	public String buyBook(Book book,User user,User bookOwner);
	
	//
	public Book getOrderBook(int userId);
}



