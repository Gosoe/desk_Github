package com.dx.action;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.dx.dao.BookDAO;
import com.dx.dao.OrderDAO;
import com.dx.dao.UserDAO;
import com.dx.dao.impl.BookDAOImpl;
import com.dx.dao.impl.OrderDAOImpl;
import com.dx.dao.impl.UserDAOImpl;
import com.dx.pojo.Admin;
import com.dx.pojo.Book;
import com.dx.pojo.Order;
import com.dx.pojo.Page;
import com.dx.pojo.User;
import com.dx.service.BookService;
import com.dx.service.impl.BookServiceImpl;

import com.opensymphony.xwork2.ActionSupport;

public class BookAction extends ActionSupport{
	private File bookPic;
	private String bookPicFileName;
	private String bookPicContentType;
	private Book book;
	private List<Book> bookList;
	public HttpServletRequest request;
	public HttpSession session;
	private Page page;
	private int currentPage;
	private Order order;
	private String bookName;
	private int searchCount;
	
	//上传管理员图书
	public String upload() throws IOException {
		request=ServletActionContext.getRequest();
		session=request.getSession();
		
		System.out.println("bookPic-->" + bookPic);
		System.out.println("bookPicFileName-->" + bookPicFileName);
		System.out.println("bookPicContentType" + bookPicContentType);
		if (bookPicContentType.indexOf("image") != -1) {
			//加时间戳
			Date date=new Date();
			SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMDDHHmmss");
			String time=sdf.format(date);
			//真实文件名
			int index=bookPicFileName.lastIndexOf(".");
			System.out.println(".后缀index:"+index);
			String realname=bookPicFileName.substring(0, index);
			String suffix=bookPicFileName.substring(index, bookPicFileName.length());
			//将更改后的书名设置到book对象中
			String uploadName=realname+"_"+time+suffix;
			book.setImgPath(uploadName);
			System.out.println("uploadName:"+uploadName);
			FileUtils.copyFile(bookPic, new File( "D:/upload/"+ uploadName));
			//需要获取userId存储到book对象中去
			if(book.getBelongToAdmin().equals("1")){
				Admin admin=(Admin)session.getAttribute("admin");
				book.setUserId(admin.getAdminId());
				System.out.println(admin.getAccount()+"session-admin");
			}else if(book.getBelongToAdmin().equals("0")){
				User user=(User)session.getAttribute("user");
				book.setBookId(user.getUserId());
				System.out.println(user.getAccount()+"session-user");
			}
			BookService bookService=new BookServiceImpl();
			bookService.upload(book);
			return "listAdminBook";
		}else{
			return "error";
		}
		
	}
	//上传用户图书
	public String uploadUserBook(){
		request=ServletActionContext.getRequest();
		session=request.getSession();
		
		System.out.println("bookPic-->" + bookPic);
		System.out.println("bookPicFileName-->" + bookPicFileName);
		System.out.println("bookPicContentType" + bookPicContentType);
		if (bookPicContentType.indexOf("image") != -1) {
			//加时间戳
			Date date=new Date();
			SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMDDHHmmss");
			String time=sdf.format(date);
			//真实文件名
			int index=bookPicFileName.lastIndexOf(".");
			System.out.println(".后缀index:"+index);
			String realname=bookPicFileName.substring(0, index);
			String suffix=bookPicFileName.substring(index, bookPicFileName.length());
			//将更改后的书名设置到book对象中
			String uploadName=realname+"_"+time+suffix;
			book.setImgPath(uploadName);
			System.out.println("uploadName:"+uploadName);
			try {
				FileUtils.copyFile(bookPic, new File( "D:/upload/"+ uploadName));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//需要获取userId存储到book对象中去
			if(book.getBelongToAdmin().equals("1")){
				Admin admin=(Admin)session.getAttribute("admin");
				book.setUserId(admin.getAdminId());
				System.out.println(admin.getAccount()+"session-admin");
			}else if(book.getBelongToAdmin().equals("0")){
				User user=(User)session.getAttribute("user");
				book.setUserId(user.getUserId());
				System.out.println(user.getAccount()+"session-user");
			}
			BookService bookService=new BookServiceImpl();
			bookService.upload(book);
			return "myUpload";
		}else{
			return "error";
		}
	}
	
	
	//只讨论admin   user另外讨论
	public String listAdminBook(){
		request=ServletActionContext.getRequest();
		session=request.getSession();
		Admin admin=(Admin)session.getAttribute("admin");
		//System.out.println("adminId:"+admin.getAdminId());
		if(page==null){
			page=new Page();
		}
		if(currentPage<=0){
			currentPage=1;
		}
		page.setCurrentPage(currentPage);
		page.setPageSize(3);
		BookDAO bookDAO=new BookDAOImpl();
		page.setDataCount(bookDAO.getAdminBookCount(admin.getAdminId()));
		BookService bookService=new BookServiceImpl();
		bookList=new ArrayList<Book>();
		bookList=bookService.selectAdminBookById(page,admin.getAdminId());
		return "listAdminBook.jsp";
	}
	
	public String updateBook(){
		int bookId=book.getBookId();
		System.out.println("up.jsp传过来的bookid?-->"+bookId);
		//book=new Book();
		BookDAO bookDAO=new BookDAOImpl();
		book=bookDAO.getBookById(bookId);
		bookDAO.update(book);
		return "updateBook.jsp";
	}
	
	public String toUpdateBook(){
		//updateBook.jsp传输过来的值是否能直接接受到？？
		System.out.println("book-->库存："+book.getStorage()+"  "+book.getNowPrice());
		BookDAO bookDAO=new BookDAOImpl();
		bookDAO.update(book);
		return "listAdminBook";
	}
	
	
	public String deleteBook(){
		BookDAO bookDAO=new BookDAOImpl();
		bookDAO.deleteBookById(book.getBookId());
		return "listAdminBook";
	}
	
	public String listAllUserBook(){
		if(page==null){
			page=new Page();
		}
		if(currentPage<=0){
			currentPage=1;
		}
		page.setCurrentPage(currentPage);
		page.setPageSize(4);
		BookDAO bookDAO=new BookDAOImpl();
		page.setDataCount(bookDAO.getAllUserBookCount());
		bookList=new ArrayList<Book>(); 
		bookList=bookDAO.selectAllUserBook(page);
		return "library.jsp";
	}
	
	public String deleteUserBook(){
		BookDAO bookDAO=new BookDAOImpl();
		bookDAO.deleteBookById(book.getBookId());
		return "listAllUserBookMethod";
	}
	
	
	
	//----------------------------userBook-----------------------------------
	//user  我的上传
	public String myUpload(){
		request=ServletActionContext.getRequest();
		session=request.getSession();
		User user=(User)session.getAttribute("user");
		System.out.println("BookAction--userId:"+user.getUserId());
		if(page==null){
			page=new Page();
		}
		if(currentPage<=0){
			currentPage=1;
		}
		page.setCurrentPage(currentPage);
		page.setPageSize(3);
		BookDAO bookDAO=new BookDAOImpl();
		page.setDataCount(bookDAO.getUserBookCount(user.getUserId()));
		BookService bookService=new BookServiceImpl();
		bookList=new ArrayList<Book>();
		System.out.println("--------------1--------------");
		bookList=bookService.selectUserBookById(page,user.getUserId());
		for(Book book:bookList){
			System.out.println("作者"+book.getAuthor());
		}
		return "myUpload.jsp";
	}
	
	//user 我的订单
	public String myOrder(){
		
		return "";
	}
	
	//user 我的购物历史
	public String myShoppingHistory(){
		
		
		return "";
	}
	
	//商城
	public String listAllBook(){
		if(page==null){
			page=new Page();
		}
		if(currentPage<=0){
			currentPage=1;
		}
		page.setCurrentPage(currentPage);
		page.setPageSize(18);
		BookDAO bookDAO=new BookDAOImpl();
		page.setDataCount(bookDAO.getAllBookCount());
		System.out.println("allBookCount-->"+bookDAO.getAllBookCount());
		
		bookList=new ArrayList<Book>();
		System.out.println("--------------1--------------");
		bookList=bookDAO.selectAllBook(page);
		return "index.jsp";
	}
	
	public String listAllSearchBook(){
		request=ServletActionContext.getRequest();
		if(page==null){
			page=new Page();
		}
		if(currentPage<=0){
			currentPage=1;
		}
		page.setCurrentPage(currentPage);
		page.setPageSize(18);
		BookDAO bookDAO=new BookDAOImpl();
		page.setDataCount(bookDAO.getAllSearchBookCount(bookName));
		searchCount=bookDAO.getAllSearchBookCount(bookName);
		request.setAttribute("searchCount", searchCount);
		bookList=new ArrayList<Book>();
		System.out.println("--------------1--------------");
		bookList=bookDAO.selectAllSearchBook(page, bookName);
		return "index.jsp";
	}
	
	//-------------以上2方法为主页----------------------
	
	
	public String deleteMyBook(){
		BookDAO bookDAO=new BookDAOImpl();
		bookDAO.deleteBookById(book.getBookId());
		return "myUpload";
	}

	public String bookDetail(){
		BookDAO bookDAO=new BookDAOImpl();
		book=bookDAO.getBookById(book.getBookId());
		return "bookDetail.jsp";
	}
	
	public String buyBook(){
		request=ServletActionContext.getRequest();
		session=request.getSession();
		User user=(User)session.getAttribute("user");
		BookDAO bookDAO=new BookDAOImpl();
		book=bookDAO.getBookById(book.getBookId());
		float userMoney=user.getMoney();
		float bookMoney=book.getNowPrice();
		System.out.println("userMoney-->"+userMoney+"------"+"bookMoney-->"+bookMoney);
		if(userMoney<bookMoney){
			request.setAttribute("times", "1");
			session.setAttribute("moneyMsg", "余额不足，请充值");
			return "userCenter";
		}else{
			UserDAO userDAO=new UserDAOImpl();
			User bookOwner=userDAO.getUserById(book.getUserId());
			bookDAO.buyBook(book, user, bookOwner);
			//插入Order表
			Order order=new Order();
			OrderDAO orderDAO=new OrderDAOImpl();
			order.setUserId(user.getUserId());
			order.setBookId(book.getBookId());
			order.setCount(1);
			Date date=new Date();
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			String dateTime=sdf.format(date);
			System.out.println("购买--111");
			order.setDateTime(dateTime);
			orderDAO.addOrder(order);
			System.out.println("购买----");
			
			return "listMyBought";
		}
	}
	
	public String listMyShopping(){
		
		return "";
	}
	
	
	
	//get/set封装
	public File getBookPic() {
		return bookPic;
	}
	public void setBookPic(File bookPic) {
		this.bookPic = bookPic;
	}
	public String getBookPicFileName() {
		return bookPicFileName;
	}
	public void setBookPicFileName(String bookPicFileName) {
		this.bookPicFileName = bookPicFileName;
	}
	public String getBookPicContentType() {
		return bookPicContentType;
	}
	public void setBookPicContentType(String bookPicContentType) {
		this.bookPicContentType = bookPicContentType;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	//request session
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
	//bookList
	public List<Book> getBookList() {
		return bookList;
	}
	public void setBookList(List<Book> bookList) {
		this.bookList = bookList;
	}
	//page
	public Page getPage() {
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	//order
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public int getSearchCount() {
		return searchCount;
	}
	public void setSearchCount(int searchCount) {
		this.searchCount = searchCount;
	}
	
	
	
}
