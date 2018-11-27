package com.dx.service;

import java.util.List;

import com.dx.pojo.Book;
import com.dx.pojo.Page;

public interface BookService {
	
	//增
	public void upload(Book book);
	
	//改(DAO层将Book全改  如果要单独改动，只需在service或者action层设置相应的book属性)
	public void update(Book book);
	
	//查
	//查询所有图书(用户+管理员)
	public List<Book> selectAllBook();
	//通过id查询该id管理员的所有图书
	public List<Book> selectAdminBookById(Page page,int adminId);
	//通过id查询该id用户的所有图书
	public List<Book> selectUserBookById(Page page,int userId);
	//通过id查询图书详情
	public Book selectBookDetailById(int bookId);
	
	//删
	public void deleteBookById(int bookId);
	
}
