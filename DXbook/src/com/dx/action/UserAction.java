package com.dx.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.dx.dao.BookDAO;
import com.dx.dao.UserDAO;
import com.dx.dao.impl.BookDAOImpl;
import com.dx.dao.impl.UserDAOImpl;
import com.dx.pojo.Admin;
import com.dx.pojo.Page;
import com.dx.pojo.User;
import com.dx.service.AdminService;
import com.dx.service.UserService;
import com.dx.service.impl.AdminServiceImpl;
import com.dx.service.impl.UserServiceImpl;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport{
	private User user;
	private List<User> userList;
	private Page page;
	private int currentPage;
	private float addMoney;
	private String account;
	
	public HttpServletRequest request;
	public HttpSession session;
	
	
	
	
	//用户注册
	public String register(){
		UserDAO userDAO=new UserDAOImpl();
		userDAO.addUser(user);
		
		request=ServletActionContext.getRequest();
		session=request.getSession();
		session.setAttribute("msg", "已注册成功，请登录");
		return "login";
	}
	
	//用户登录
	public String login(){
		request=ServletActionContext.getRequest();
		session=request.getSession();
		String account=user.getAccount();
		String password=user.getPassword();
		System.out.println(account+"  "+password);
		UserDAO userDAO=new UserDAOImpl();
		user=new User();
		user=userDAO.getUserByAccount(account);
		if(user!=null){
			System.out.println("userid-->"+user.getUserId()+"session.user-->"+user.getAccount()+"  "+user.getPassword());
			if(account.equals(user.getAccount()) && password.equals(user.getPassword())){
				session.setAttribute("user", user);
				session.setMaxInactiveInterval(60*60);
				System.out.println("session------");
				return "index";  //逻辑有错  
			}
		session.setAttribute("msg", "用户名不存在！请确认后再次输入");
		return "userLoginFailure";
		}else{
			session.setAttribute("msg", "用户名不存在！请确认后再次输入");
			return "userLoginFailure";
		}
	}
	
	
	
	//----------------管理员操作----------------------
	public String listAllUser(){
		if(page==null){
			page=new Page();
		}
		if(currentPage<=0){
			currentPage=1;
		}
		page.setCurrentPage(currentPage);
		page.setPageSize(4);
		UserDAO userDAO=new UserDAOImpl();
		UserService userService=new UserServiceImpl();
		page.setDataCount(userDAO.getUserCount());
		userList=new ArrayList<User>();
		userList=userService.selectAllUser(page);
		for(User user:userList){
			System.out.println("userList--"+user.getAccount());
		}
		return "listUser";
	}
	
	public String userRecharge(){
		System.out.println("userRecharge--UserId-->"+user.getUserId());
		int userId=user.getUserId();
		user=new User();
		UserDAO userDAO=new UserDAOImpl();
		user=userDAO.getUserById(userId);
		return "userRecharge.jsp";
	}
	
	public String toRechargeMoney(){
		System.out.println("toRechargeMoney--UserId-->"+user.getUserId());
		int userId=user.getUserId();
		float userMoney=user.getMoney();
		UserDAO userDAO=new UserDAOImpl();
		userDAO.rechargeMoney(addMoney+userMoney, userId);
		return "listUserMethod";
	}
	
	public String deleteUser(){
		UserDAO userDAO=new UserDAOImpl();
		userDAO.deleteUserById(user.getUserId());
		return "listUserMethod";
	}
	
	
	
	//-------------------------用户自己操作------------------------------
	
	public String rechargeMoney(){
		request=ServletActionContext.getRequest();
		session=request.getSession();
		
		System.out.println("add=="+user.getAddMoney());
		addMoney=user.getAddMoney();
		account=user.getAccount();
		UserDAO userDAO=new UserDAOImpl();
		user=userDAO.getUserByAccount(account);
		int userId=user.getUserId();
		float userMoney=user.getMoney();
		System.out.println(userMoney+"===========");
		userDAO.rechargeMoney(addMoney+userMoney, userId);
		user=userDAO.getUserByAccount(account);
		session.setAttribute("user", user);
		return "userCenter.jsp";
	}
	
	public String myInfo(){
		request=ServletActionContext.getRequest();
		session=request.getSession();
		user=(User)session.getAttribute("user");
		String account=user.getAccount();
		UserDAO userDAO=new UserDAOImpl();
		user=new User();
		user=userDAO.getUserByAccount(account);
		session.setAttribute("user", user);
		
		return "userMyInfo";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


	//get/set封装
	public Page getPage() {
		return page;
	}
	public List<User> getUserList() {
		return userList;
	}
	public void setUserList(List<User> userList) {
		this.userList = userList;
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
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public float getAddMoney() {
		return addMoney;
	}
	public void setAddMoney(float addMoney) {
		this.addMoney = addMoney;
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
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	
	
	
	
	
	
	
	
}
