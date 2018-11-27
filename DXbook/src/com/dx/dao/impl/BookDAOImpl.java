package com.dx.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dx.dao.BookDAO;
import com.dx.pojo.Book;
import com.dx.pojo.Page;
import com.dx.pojo.User;
import com.dx.tools.DBUtil;

public class BookDAOImpl implements BookDAO {

	@Override
	public void upload(Book book) {
		System.out.println("DAOImpl---------up");
		// TODO Auto-generated method stub
		Connection conn=DBUtil.getConn();
		String sql="insert into book values(null,?,?,?,?,?,?,?,?,?,default,default,?)";
		DBUtil.excuteSql(sql, book.getUserId(),book.getName(),book.getAuthor(),book.getBookType(),book.getBrief(),book.getStorage(),book.getCostPrice(),book.getNowPrice(),book.getImgPath(),book.getBelongToAdmin());
		DBUtil.closeConnection();
	}
	
	@Override
	public void update(Book book) {
		// TODO Auto-generated method stub
		System.out.println("UpdateDAO-->id:"+book.getBookId());
		Connection conn=DBUtil.getConn();
		String sql="update book set storage=?,nowPrice=? where bookId=?";
		DBUtil.excuteSql(sql,book.getStorage(),book.getNowPrice(),book.getBookId());
		DBUtil.closeConnection();
	}
	
	@Override
	public List<Book> selectAllBook(Page page) {
		// TODO Auto-generated method stub
		List<Book> bookList=new ArrayList<Book>();
		try {
			Connection conn=DBUtil.getConn();
			String sql="select * from book b where b.storage>0 limit ?,?";
			ResultSet rs=DBUtil.excuteQuery(sql,(page.getCurrentPage()-1)*page.getPageSize(),page.getPageSize());    
			//user表中的userid 与admin表中的adminId有重复，会冲突
			while(rs.next()){
				Book book=new Book();
				book.setBookId(rs.getInt(1));
				book.setUserId(rs.getInt(2));
				book.setName(rs.getString(3));
				book.setAuthor(rs.getString(4));
				book.setBookType(rs.getString(5));
				book.setBrief(rs.getString(6));
				book.setStorage(rs.getInt(7));
				book.setCostPrice(rs.getFloat(8));
				book.setNowPrice(rs.getFloat(9));
				book.setImgPath(rs.getString(10));
				book.setIsSold(rs.getString(11));
				book.setRecommendation(rs.getString(12));
				book.setBelongToAdmin(rs.getString(13));
				bookList.add(book);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.closeConnection();
		}
		return bookList;
	}
	
	@Override
	public int getAllBookCount() {
		// TODO Auto-generated method stub
		int count=0;
		try {
			Connection conn=DBUtil.getConn();
			String sql="select count(bookId) from book b where b.storage>0";
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
	public List<Book> selectAllSearchBook(Page page,String bookName) {
		// TODO Auto-generated method stub
		List<Book> bookList=new ArrayList<Book>();
		try {
			Connection conn=DBUtil.getConn();
			String sql="select * from book b where b.storage>0 and b.name like ? limit ?,?";
			ResultSet rs=DBUtil.excuteQuery(sql,"%"+bookName+"%",(page.getCurrentPage()-1)*page.getPageSize(),page.getPageSize());    
			//user表中的userid 与admin表中的adminId有重复，会冲突
			while(rs.next()){
				Book book=new Book();
				book.setBookId(rs.getInt(1));
				book.setUserId(rs.getInt(2));
				book.setName(rs.getString(3));
				book.setAuthor(rs.getString(4));
				book.setBookType(rs.getString(5));
				book.setBrief(rs.getString(6));
				book.setStorage(rs.getInt(7));
				book.setCostPrice(rs.getFloat(8));
				book.setNowPrice(rs.getFloat(9));
				book.setImgPath(rs.getString(10));
				book.setIsSold(rs.getString(11));
				book.setRecommendation(rs.getString(12));
				book.setBelongToAdmin(rs.getString(13));
				bookList.add(book);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.closeConnection();
		}
		return bookList;
	}
	
	@Override
	public int getAllSearchBookCount(String bookName) {
		// TODO Auto-generated method stub
		int count=0;
		try {
			Connection conn=DBUtil.getConn();
			String sql="select count(bookId) from book b where b.storage>0 and b.name like ?";
			ResultSet rs=DBUtil.excuteQuery(sql,"%"+bookName+"%");
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
	
	
	
	
	//--------------------------------------------------------
	
	
	
	
	
	
	//获取所用用户图书
	@Override
	public int getAllUserBookCount() {
		// TODO Auto-generated method stub
		int count=0;
		try {
			Connection conn=DBUtil.getConn();
			String sql="select count(bookId) from book b,user u where b.userId=u.userId";
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
	public List<Book> selectAllUserBook(Page page) {
		List<Book> bookList=new ArrayList<Book>();
		try {
			Connection conn=DBUtil.getConn();
			String sql="select b.*,u.name from book b,user u where b.userId=u.userId limit ?,?";
			ResultSet rs=DBUtil.excuteQuery(sql,(page.getCurrentPage()-1)*page.getPageSize(),page.getPageSize());    
			//user表中的userid 与admin表中的adminId有重复，会冲突
			while(rs.next()){
				Book book=new Book();
				book.setBookId(rs.getInt(1));
				book.setUserId(rs.getInt(2));
				book.setName(rs.getString(3));
				book.setAuthor(rs.getString(4));
				book.setBookType(rs.getString(5));
				book.setBrief(rs.getString(6));
				book.setStorage(rs.getInt(7));
				book.setCostPrice(rs.getFloat(8));
				book.setNowPrice(rs.getFloat(9));
				book.setImgPath(rs.getString(10));
				book.setIsSold(rs.getString(11));
				book.setRecommendation(rs.getString(12));
				book.setBelongToAdmin(rs.getString(13));
				book.setBookOwner(rs.getString(14));
				bookList.add(book);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.closeConnection();
		}
		return bookList;
	}
	
	@Override
	public int getAdminBookCount(int adminId) {
		// TODO Auto-generated method stub
		int count=0;
		try {
			Connection conn=DBUtil.getConn();
			String sql="select count(b.bookId) from book b,admin a where b.belongToAdmin='1' and b.userId=?";
			ResultSet rs=DBUtil.excuteQuery(sql, adminId);
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
	public List<Book> selectAdminBookById(Page page,int adminId) {
		// TODO Auto-generated method stub
		List<Book> bookList=new ArrayList<Book>();
		try {
			Connection conn=DBUtil.getConn();
			String sql="select b.*,a.name from book b,admin a where b.belongToAdmin='1' and b.userId=? limit ?,?";
			ResultSet rs=DBUtil.excuteQuery(sql, adminId,(page.getCurrentPage()-1)*page.getPageSize(),page.getPageSize());  
			//user表中的userid 与admin表中的adminId有重复，会冲突(但多加条件b.belongToAdmin='1'就好了)
			while(rs.next()){
				Book book=new Book();
				book.setBookId(rs.getInt(1));
				book.setUserId(rs.getInt(2));
				book.setName(rs.getString(3));
				book.setAuthor(rs.getString(4));
				book.setBookType(rs.getString(5));
				book.setBrief(rs.getString(6));
				book.setStorage(rs.getInt(7));
				book.setCostPrice(rs.getFloat(8));
				book.setNowPrice(rs.getFloat(9));
				book.setImgPath(rs.getString(10));
				book.setIsSold(rs.getString(11));
				book.setRecommendation(rs.getString(12));
				book.setBelongToAdmin(rs.getString(13));
				book.setBookOwner(rs.getString(14));
				bookList.add(book);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.closeConnection();
		}
		return bookList;
	}

	@Override
	public int getUserBookCount(int userId) {
		// TODO Auto-generated method stub
		int count=0;
		try {
			Connection conn=DBUtil.getConn();
			String sql="select count(b.bookId) from book b where b.userId=?";
			ResultSet rs=DBUtil.excuteQuery(sql, userId);
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
	public List<Book> selectUserBookById(Page page,int userId) {
		List<Book> bookList=new ArrayList<Book>();
		try {
			Connection conn=DBUtil.getConn();
			String sql="select b.*,a.name from book b,admin a where b.userId=? limit ?,?";
			ResultSet rs=DBUtil.excuteQuery(sql, userId,(page.getCurrentPage()-1)*page.getPageSize(),page.getPageSize());  
			while(rs.next()){
				Book book=new Book();
				book.setBookId(rs.getInt(1));
				book.setUserId(rs.getInt(2));
				book.setName(rs.getString(3));
				book.setAuthor(rs.getString(4));
				book.setBookType(rs.getString(5));
				book.setBrief(rs.getString(6));
				book.setStorage(rs.getInt(7));
				book.setCostPrice(rs.getFloat(8));
				book.setNowPrice(rs.getFloat(9));
				book.setImgPath(rs.getString(10));
				book.setIsSold(rs.getString(11));
				book.setRecommendation(rs.getString(12));
				book.setBelongToAdmin(rs.getString(13));
				book.setBookOwner(rs.getString(14));
				bookList.add(book);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.closeConnection();
		}
		return bookList;
	}
	
	@Override
	public Book selectBookDetailById(int bookId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void deleteBookById(int bookId) {
		// TODO Auto-generated method stub
		Connection conn=DBUtil.getConn();
		String sql="delete from book where bookId=?";
		DBUtil.excuteSql(sql, bookId);
		DBUtil.closeConnection();
	}
	
	public Book getBookById(int bookId){
		Book book=new Book();
		try {
			Connection conn=DBUtil.getConn();
			String sql="select * from book where bookId=?";
			ResultSet rs=DBUtil.excuteQuery(sql, bookId);
			while(rs.next()){
				book.setBookId(rs.getInt(1));
				book.setUserId(rs.getInt(2));
				book.setName(rs.getString(3));
				book.setAuthor(rs.getString(4));
				book.setBookType(rs.getString(5));
				book.setBrief(rs.getString(6));
				book.setStorage(rs.getInt(7));
				book.setCostPrice(rs.getFloat(8));
				book.setNowPrice(rs.getFloat(9));
				book.setImgPath(rs.getString(10));
				book.setIsSold(rs.getString(11));
				book.setRecommendation(rs.getString(12));
				book.setBelongToAdmin(rs.getString(13));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.closeConnection();
		}
		return book;
	}

	@Override
	public String buyBook(Book book,User user,User bookOwner) {
		// TODO Auto-generated method stub
		Connection conn=DBUtil.getConn();
			//1.将图书的库存减一  同时将isSold标记为‘1’，表示已出售
			String sql1="update book set storage=?,isSold='1' where bookId=?";
			DBUtil.excuteSql(sql1,book.getStorage()-1,book.getBookId());
			//2.购买者钱包减去买书钱
			String sql2="update user set money=? where userId=?";
			DBUtil.excuteSql(sql2, user.getMoney()-book.getNowPrice(),user.getUserId());
			//2.卖书者钱包加上卖书钱
			String sql3="update user set money=? where userId=?";
			DBUtil.excuteSql(sql3, bookOwner.getMoney()+book.getNowPrice(),bookOwner.getUserId());
			System.out.println("----BookDAO---318");
			
			DBUtil.closeConnection();
		return null;
	}

	@Override
	public Book getOrderBook(int userId) {
		// TODO Auto-generated method stub
		Book book=new Book();
		try {
			Connection conn=DBUtil.getConn();
			String sql="select * from book where userId=? and isSold='1'";
			ResultSet rs=DBUtil.excuteQuery(sql, userId);
			while(rs.next()){
				book.setBookId(rs.getInt(1));
				book.setUserId(rs.getInt(2));
				book.setName(rs.getString(3));
				book.setAuthor(rs.getString(4));
				book.setBookType(rs.getString(5));
				book.setBrief(rs.getString(6));
				book.setStorage(rs.getInt(7));
				book.setCostPrice(rs.getFloat(8));
				book.setNowPrice(rs.getFloat(9));
				book.setImgPath(rs.getString(10));
				book.setIsSold(rs.getString(11));
				book.setRecommendation(rs.getString(12));
				book.setBelongToAdmin(rs.getString(13));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.closeConnection();
		}
		return book;
	}
	
	

}
