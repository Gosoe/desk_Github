package com.dx.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.dx.dao.AdminDAO;
import com.dx.dao.impl.AdminDAOImpl;
import com.dx.pojo.Admin;
import com.dx.pojo.Page;
import com.dx.service.AdminService;
import com.dx.service.impl.AdminServiceImpl;
import com.opensymphony.xwork2.ActionSupport;

public class AdminAction extends ActionSupport{
	private Admin admin;
	private Page page;
	private List<Admin> adminList;
	public HttpServletRequest request;
	public HttpSession session;
	public float addMoney;
	//管理员登录
	public String login(){
		
		request=ServletActionContext.getRequest();
		session=request.getSession();
		String account=admin.getAccount();
		String password=admin.getPassword();
		System.out.println(account+"  "+password);
		AdminService adminService=new AdminServiceImpl();
		admin=new Admin();
		admin=adminService.getAdminByAccount(account);
		if(admin!=null){
				if(account.equals(admin.getAccount()) && password.equals(admin.getPassword())){
					session.setAttribute("admin", admin);
					session.setMaxInactiveInterval(60*60*2);
			}
			return "adminMain";
		}else{
			session.setAttribute("msg", "用户名不存在！请确认后再次输入");
			return "loginFailure";
		}
	}
	
	public String myInfo(){
		request=ServletActionContext.getRequest();
		session=request.getSession();
		admin=(Admin)session.getAttribute("admin");
		String account=admin.getAccount();
		AdminDAO adminDAO=new AdminDAOImpl();
		admin=new Admin();
		admin=adminDAO.getAdminByAccount(account);
		return "myInfo";
	}
	
	public String recharge(){
		System.out.println("recharge-->"+admin.getAccount());
		String account=admin.getAccount();
		AdminDAO adminDAO=new AdminDAOImpl();
		admin=new Admin();
		admin=adminDAO.getAdminByAccount(account);
		return "recharge.jsp";
	}
	
	public String rechargeMoney(){
		String account=admin.getAccount();
		admin=new Admin();
		AdminDAO adminDAO=new AdminDAOImpl();
		admin=adminDAO.getAdminByAccount(account);
		adminDAO.rechargeMoney(addMoney+admin.getMoney(), admin.getAdminId());
		return "tomyInfo";
	}
	
	
	public String logout(){
		request=ServletActionContext.getRequest();
		session=request.getSession();
		session.invalidate();
		return "loginFailure";
	}
	
	
	//get/set封装
	public Admin getAdmin() {
		return admin;
	}
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	public Page getPage() {
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}
	public List<Admin> getAdminList() {
		return adminList;
	}
	public void setAdminList(List<Admin> adminList) {
		this.adminList = adminList;
	}
	//
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
	
	public float getAddMoney() {
		return addMoney;
	}
	public void setAddMoney(float addMoney) {
		this.addMoney = addMoney;
	}
	
	
}
