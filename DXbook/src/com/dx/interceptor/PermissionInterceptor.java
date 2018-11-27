package com.dx.interceptor;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class PermissionInterceptor implements Interceptor{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		//获取action上下文
				ActionContext ac = invocation.getInvocationContext();
				//获取request
				HttpServletRequest request = (HttpServletRequest) ac.get(ServletActionContext.HTTP_REQUEST);
				String username = request.getParameter("username");
				String password = request.getParameter("password");
				//执行下一个拦截器,如果没有拦截器 则执行方法
				String result = "";
				if("admin".equals(username) && "123".equals(password)){
					System.out.println("登录成功");
					//invocation.invoke(); 返回的为调用对应action方法的返回字符串
					result = invocation.invoke();
				}else{
					result = "error";
				}
				System.out.println(result);
				//根据return的值  会去找对应的请求结果 即result name="xxx"中 的XXX
				return result;
	}

}
