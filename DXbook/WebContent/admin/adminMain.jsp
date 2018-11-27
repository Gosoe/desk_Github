<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
  <head>
    
    <title>My JSP 'bgMain.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="<%=path %>/css/bgMain.css">
	<link  rel="stylesheet" href="<%=path %>/css/global.css" />
<link  rel="stylesheet" href="<%=path %>/css/index.css" />
  </head>
	<body>
		
		
		<div>  <!-- id="mainDiv" -->
			<div id="">
				<%@include file="top.jsp" %>
			</div>
			
			<div id="bottomDiv">
				
				<div id="bottomLeft" style="text-align: center;display: inline-block;margin-top: 35px;">
					<p style="display: inline-block;margin: 0 auto;"><b>1.个人管理</b></p>
					<div style="border:thin;border-color: orange;">
						<div style="background: #efcccc;width:160px;height:3px;margin: 0 auto;"></div>
						<div style="margin-top: 2px;margin: 0 auto;align:center;">
							<a href="AdminAction!myInfo" target="iframe">个人信息</a>
						</div>
						<div style="margin-top: 2px;margin: 0 auto;align:center;">
							<a href="admin/uploadBook.jsp" target="iframe">发布图书</a>
						</div>
						<div style="margin-top: 2px;margin: 0 auto;align:center;">
							<a href="BookAction!listAdminBook?currentPage=1" target="iframe">我的图书</a>
						</div>
						<!-- <div style="margin-top: 2px;margin: 0 auto;align:center;">
							<a href="AdminAction!myInfo" target="iframe">我的订单</a>
						</div> -->
					</div>	
					
					<div style="text-align: center;margin-top: 20px;">
						<p style="display: inline-block;margin: 0 auto;"><b>2.用户管理</b></p>
						<div style="background: #efcccc;width:160px;height:3px;margin: 0 auto;"></div>
						<div style="margin-top: 2px;margin: 0 auto;align:center;">
							<a href="UserAction!listAllUser" target="iframe">查看用户列表（可充值）</a>
						</div>
					</div>	
					
					<div style="text-align: center;margin-top: 20px;">
						<p style="display: inline-block;margin: 0 auto;"><b>3.图书管理</b></p>
						<div style="background: #efcccc;width:160px;height:3px;margin: 0 auto;"></div>
						<div style="margin-top: 2px;margin: 0 auto;align:center;">
							<a href="BookAction!listAllUserBook" target="iframe">图书馆</a>
						</div>
					</div>	
					
					<div style="text-align: center;margin-top: 20px;">
						<div style="background: #efcccc;width:160px;height:3px;margin: 0 auto;"></div>
						<div style="margin-top: 2px;margin: 0 auto;align:center;">
							<a href="AdminAction!logout">注销退出</a>
						</div>
					</div>
				</div>
				<div id="bottomRight" style="display: inline-block;">
					<iframe id="bottomRight" name="iframe"></iframe>
				</div>
				</span>
			</div>
		</div>
		
	</body>
</html>
