<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>大象旧书网-个人信息</title>
<script type="text/javascript" src="<%=path %>/js/jquery-1.8.3.js" ></script>
<script type="text/javascript" src="<%=path %>/js/global.js" ></script>
<script type="text/javascript" src="<%=path %>/js/userCenter.js" ></script>
<link  rel="stylesheet" href="<%=path %>/css/global.css" />
<link  rel="stylesheet" href="<%=path %>/css/userCenter.css" />
</head>
<body>
<jsp:include page="/share/header2.jsp" />
<!-- Content Start -->
<div class="content">

<!-- Position Start -->
<div class="breadcrumb" >
<a href="#" target="_blank" class="domain"><b class="domain">个人中心</b></a>&nbsp;&gt;&nbsp;
<span>修改</span>
</div>
<!-- Position End -->

<!-- left Start -->
<div class="content_left">
<div class="user_center">
<ul>
<li class="user_center_header"><h3 class="left_title">我的交易</h3><a class="slideUp"></a>
    <ul>
    	<li><a href="BookAction!myUpload">我的上传</a></li>
    	<li><a href="OrderAction!myOrder">我的订单</a></li>
        <li><a href="OrderAction!myShoppingHistory">购物历史</a></li>
    </ul>
</li>

</div>
</div>
<!-- left End -->

<!-- right Start -->
<div class="content_right">
<div class="user_right_div">
<!-- 显示个人基本信息开始 -->
<div class="info_left" style="width:860px;">
	<div style="margin-top: 2px;float: left;" >
    	<table border="1px" cellspacing="1px" bordercolor="#eeddee" style="text-align: center;border: 1px;">
    	    	<tr style="text-align: center;height: 60px;">
    				<td width="25px">序号</td>
    				<td width="80px">书名</td>
    				<td width="80px">作者</td>
    				<td width="60px">类型</td>
    				<td width="30px">库存</td>
    				<td width="60px">原价</td>
    				<td width="60px">现价</td>
    				<td width="100px">图片</td>
    				<td width="100px">出售</td>
    				<td width="80px">操作</td>
    			</tr>
    		<c:forEach var="book" items="${bookList}" varStatus="status">
    	    	<tr height: 70px;>
    				<td>${status.count}</td>
    				<td>${book.name}</td>
    				<td>${book.author}</td>
    				<td>${book.bookType}</td>
    				<td>${book.storage}</td>
    				<td>${book.costPrice}</td>
    				<td>${book.nowPrice}</td>
    				<td><img alt="图书图片" src="${pageContext.request.contextPath }/upload/${book.imgPath}" width="50px" height="50px"></td>
    				<td>
    					<c:choose>
    						<c:when test="${book.isSold=='1'}"><font color="red">已出售</font></c:when>
    						<c:otherwise><font color="#dddddd">待出售</font></c:otherwise> 
    					</c:choose>
    				</td>
    				<td><a href="BookAction!deleteMyBook?book.bookId=${book.bookId}">删除</a></td>
    			</tr>
    		</c:forEach>
    		    <tr>
    				<td colspan="12" style="text-align: center;">
		    			<a href="BookAction!myUpload?currentPage=1">首页</a>&nbsp;
		    			<a href="BookAction!myUpload?currentPage=${page.currentPage<=1 ? 1:(page.currentPage-1)}">上一页</a>&nbsp;
		    			<a href="BookAction!myUpload?currentPage=${page.currentPage>=page.pageSum ? (page.pageSum):(page.currentPage+1)}">下一页</a>&nbsp;
		    			<a href="BookAction!myUpload?currentPage=${page.pageSum}">尾页</a>
		    			&nbsp;&nbsp;第${page.currentPage}/${page.pageSum}页&nbsp;&nbsp;
		             	总共${page.dataCount}条&nbsp;&nbsp;
    				</td>
    			</tr>
    	</table>
    </div>
</div>
<!-- 显示个人基本信息结束 -->
<!-- 修改头像开始 -->
<!-- 修改头像结束 -->
</div>
</div>
<!-- right End -->
</div>
<!-- Content Start -->

<!-- footer Start -->
<jsp:include page="/share/footer.jsp" />
<!-- footer End -->
</body>
</html>
