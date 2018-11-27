<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div style="margin-left: 2px;margin-top: 2px;">
    	<h3 style="margin-left: 50px;">用户列表</h3>
    	<table border="1px" cellspacing="0" bordercolor="#eeddee" style="text-align: center;">
    	    	<tr>
    				<td width="25px">序号</td>
    				<td width="120px">账号</td>
    				<td width="100px">密码</td>
    				<td width="80px">真名</td>
    				<td width="40px">性别</td>
    				<td width="70px">身份证号</td>
    				<td width="170px">邮件地址</td>
    				<td width="80px">邮政编码</td>
    				<td width="100px">电子邮箱</td>
    				<td width="60px">余额</td>
    				<td width="60px">会员</td>
    				<td width="60px">操作1</td>
    				<td width="60px">操作2</td>
    			</tr>
    		<c:forEach var="user" items="${userList}" varStatus="status">
    	    	<tr>
    				<td>${status.count}</td>
    				<td>${user.account}</td>
    				<td>${user.password}</td>
    				<td>${user.name}</td>
    				<td>${user.sex}</td>
    				<td>${user.IDCard}</td>
    				<td>${user.postAddress}</td>
    				<td>${user.postCode}</td>
    				<td>${user.email}</td>
    				<td>${user.money}</td> 
    				<td>
      					<c:choose>
    						<c:when test="${user.isAdmin=='1'}"><font color="red">会员</font></c:when>
    						<c:otherwise><font color="#dddddd">\</font></c:otherwise>
    					</c:choose>
    				</td> 
    				<td><a href="UserAction!userRecharge?user.userId=${user.userId}">充值</a></td>
    				<td><a href="UserAction!deleteUser?user.userId=${user.userId}">删除</a></td>
    			</tr>
    			</c:forEach>
    		    <tr>
    				<td colspan="12" style="text-align: center;">
		    			<a href="UserAction!listAllUser?currentPage=1">首页</a>&nbsp;
		    			<a href="UserAction!listAllUser?currentPage=${page.currentPage<=1 ? 1:(page.currentPage-1)}">上一页</a>&nbsp;
		    			<a href="UserAction!listAllUser?currentPage=${page.currentPage>=page.pageSum ? (page.pageSum):(page.currentPage+1)}">下一页</a>&nbsp;
		    			<a href="UserAction!listAllUser?currentPage=${page.pageSum}">尾页</a>
		    			&nbsp;&nbsp;第${page.currentPage}/${page.pageSum}页&nbsp;&nbsp;
		             	总共${page.dataCount}条&nbsp;&nbsp;
    				</td>
    			</tr>
    	</table>
    </div>
</body>
</html>