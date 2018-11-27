package com.dx.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dx.pojo.Admin;

public class AdminPermissionFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest)request;
		HttpSession session = httpRequest.getSession();
		HttpServletResponse resp=(HttpServletResponse)response;
			Admin admin=new Admin();
			admin=(Admin)session.getAttribute("admin");
			//System.out.println(admin.getAccount()+"--------");
		if(admin!= null){
			chain.doFilter(request,response);
		} else{
			//System.out.println("没有登录");
			session.setAttribute("msg", "请登录后再操作");
			//request.getRequestDispatcher("/adminLogin.jsp").forward(request, response);
			resp.sendRedirect(request.getServletContext().getContextPath()+"/adminLogin.jsp");
		}
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
