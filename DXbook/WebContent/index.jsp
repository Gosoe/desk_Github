<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>大象图书交换网</title>
<link  rel="stylesheet" href="<%=path %>/css/global.css" />
<link  rel="stylesheet" href="<%=path %>/css/index.css" />
</head>

<body>
<%@include file="../share/header.jsp" %>
	<div class="content" style="display: block;">
		<div  >
					
			<div style="margin-top: 0 auto;width:960px;text-align: center;display: block;" >
    			<c:forEach var="book" items="${bookList}" varStatus="status">
    				<div style="width: 160px;height: 180px;display:inline;float: left;">
    					<div style="margin: 0 auto;text-align: center;">
    						<a href="BookAction!bookDetail?book.bookId=${book.bookId}">
    							<img alt="图书图片" style="display: block;" width="140px" height="140px" src="${pageContext.request.contextPath }/upload/${book.imgPath}">
    						</a>
    						<p>《${book.name}》</p>
    						<p><s>￥${book.costPrice}</s>&nbsp;&nbsp;&nbsp;&nbsp;
    						   <font color="red">&nbsp;￥${book.nowPrice}</font>
    						</p>
    					</div>
    				</div>
    			<c:if test="${status.count % 6==0 }"><br></c:if>
				</c:forEach>	
			</div>					
			<div style="text-align: center;margin-top: 10px;font-size: 14px;width: 960px;display: block;">
    			<div style="display: block;">
	    			<a href="BookAction!listAllBook?currentPage=1">首页</a>&nbsp;
	    			<a href="BookAction!listAllBook?currentPage=${page.currentPage<=1 ? 1:(page.currentPage-1)}">上一页</a>&nbsp;
	    			<a href="BookAction!listAllBook?currentPage=${page.currentPage>=page.pageSum ? (page.pageSum):(page.currentPage+1)}">下一页</a>&nbsp;
	    			<a href="BookAction!listAllBook?currentPage=${page.pageSum}">尾页</a>
	    			&nbsp;&nbsp;第${page.currentPage}/${page.pageSum}页&nbsp;&nbsp;
	             	总共${page.dataCount}条&nbsp;&nbsp;
	            </div>
    	   </div>
    	   
    </div>
	</div>

	
<%@include file="../share/footer.jsp" %>
</body>
</html>
