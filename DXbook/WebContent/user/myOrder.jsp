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
<div >
	<p style="font-size: 14pt;"><b>待处理的订单</b></p>
    	<table border="1px" cellspacing="1px" bordercolor="#eeddee" style="text-align: center;border: 1px;font-size: 12pt;">
    	    	<tr style="text-align: center;height: 60px;">
    				<td width="30px">序号</td>
    				<td width="140px">书名</td>
    				<td width="100px">购买数量</td>
    				<td width="180px">订单日期</td>
    				<td width="100px">付款状态</td>
    				<td width="100px">发货状态</td>
    				<td width="100px">收货状态</td>
    				<td width="80px">操作</td>
    			</tr>
    		<c:forEach var="order" items="${orderList}" varStatus="status">
    	    	<tr style="height: 50px;">
    				<td>${status.count}</td>
    				<td>${order.bookName}</td>
    				<td>${order.count}</td>
    				<td>${order.dateTime}</td>
    				<td>
    					<c:choose>
    						<c:when test="${order.isDeliveried=='1'}"><font color="red">已发送</font></c:when>
    						<c:otherwise><font color="#dddddd">待发送</font></c:otherwise> 
    					</c:choose>
    				</td>
    				<td>
    					<c:choose>
    						<c:when test="${order.isAccepted=='1'}"><font color="red">已签收</font></c:when>
    						<c:otherwise><font color="#dddddd">待签收</font></c:otherwise> 
    					</c:choose>
    				</td>
    				<td>
    					<c:choose>
    						<c:when test="${order.isPaid=='1'}"><font color="red">已付款</font></c:when>
    						<c:otherwise><font color="#dddddd">待付款</font></c:otherwise> 
    					</c:choose>
    				</td>
    				<td><a href="OrderAction!sendBook?order.orderId=${order.orderId}">已发货</a></td>
    			</tr>
    		</c:forEach>
    	</table>
	</div>
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
