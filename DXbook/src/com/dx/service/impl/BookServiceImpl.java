package com.dx.service.impl;

import java.util.List;

import com.dx.dao.BookDAO;
import com.dx.dao.impl.BookDAOImpl;
import com.dx.pojo.Book;
import com.dx.pojo.Page;
import com.dx.service.BookService;

public class BookServiceImpl implements BookService{

	@Override
	public void upload(Book book) {
		// TODO Auto-generated method stub
		BookDAO bookDAO=new BookDAOImpl();
		bookDAO.upload(book);
	}

	@Override
	public void update(Book book) {
		// TODO Auto-generated method stub
		BookDAO bookDAO=new BookDAOImpl();
		bookDAO.update(book);
	}

	@Override
	public List<Book> selectAllBook() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Book> selectAdminBookById(Page page,int adminId) {
		BookDAO bookDAO=new BookDAOImpl();
		return bookDAO.selectAdminBookById(page,adminId);
	}

	@Override
	public List<Book> selectUserBookById(Page page,int userId) {
		BookDAO bookDAO=new BookDAOImpl();
		return bookDAO.selectUserBookById(page,userId);
		
	}

	@Override
	public Book selectBookDetailById(int bookId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteBookById(int bookId) {
		// TODO Auto-generated method stub
		BookDAO bookDAO=new BookDAOImpl();
		bookDAO.deleteBookById(bookId);
	}
	
	
	
}
