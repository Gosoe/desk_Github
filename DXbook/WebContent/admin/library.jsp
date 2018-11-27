<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>图书馆</title>
</head>
<body>
		<div style="margin-left: 2px;margin-top: 2px;">
    	<h3 style="margin-left: 50px;">图书馆</h3>
    	<table border="1px" cellspacing="0" bordercolor="#eeddee" style="text-align: center;">
    	    	<tr>
    				<td width="25px">序号</td>
    				<td width="120px">书名</td>
    				<td width="100px">作者</td>
    				<td width="90px">类型</td>
    				<td width="40px">库存</td>
    				<td width="70px">原价</td>
    				<td width="70px">现出售价</td>
    				<td width="180px">图片</td>
    				<td width="100px">是否已售</td>
    				<td width="80px">是否推荐</td>
    				<td width="120px">操作1</td>
    			</tr>
    		<c:forEach var="book" items="${bookList}" varStatus="status">
    	    	<tr>
    				<td>${status.count}</td>
    				<td>${book.name}</td>
    				<td>${book.author}</td>
    				<td>${book.bookType}</td>
    				<td>${book.storage}</td>
    				<td>${book.costPrice}</td>
    				<td>${book.nowPrice}</td>
    				<td><img alt="图书图片" src="upload/${book.imgPath}" width="50px" height="50px"></td>
    				<td>
    					<c:choose>
    						<c:when test="${book.isSold=='1'}"><font color="red">已经出售</font></c:when>
    						<c:otherwise><font color="#dddddd">待出售</font></c:otherwise>
    					</c:choose>
    				</td>
    				<td>
    					<c:choose>
    						<c:when test="${book.recommendation=='1'}"><font color="red">已推荐</font></c:when>
    						<c:otherwise><font color="#dddddd">不推荐</font></c:otherwise>
    					</c:choose>
    				</td> 
    				<td><a href="BookAction!deleteUserBook?book.bookId=${book.bookId}">禁止发布</a></td>
    			</tr>
    		</c:forEach>
    		    <tr>
    				<td colspan="12" style="text-align: center;">
		    			<a href="BookAction!listAllUserBook?currentPage=1">首页</a>&nbsp;
		    			<a href="BookAction!listAllUserBook?currentPage=${page.currentPage<=1 ? 1:(page.currentPage-1)}">上一页</a>&nbsp;
		    			<a href="BookAction!listAllUserBook?currentPage=${page.currentPage>=page.pageSum ? (page.pageSum):(page.currentPage+1)}">下一页</a>&nbsp;
		    			<a href="BookAction!listAllUserBook?currentPage=${page.pageSum}">尾页</a>
		    			&nbsp;&nbsp;第${page.currentPage}/${page.pageSum}页&nbsp;&nbsp;
		             	总共${page.dataCount}条&nbsp;&nbsp;
    				</td>
    			</tr>
    	</table>
    </div>
</body>
</html>