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
        <li><a href="OrderAction!myShoppingHistory">已付款</a></li>
    </ul>
</li>
	
</div>
</div>
<!-- left End -->

<!-- right Start -->
<div class="content_right">
<div class="user_right_div">
<!-- 显示个人基本信息开始 -->
<div class="info_left">
	<p class="info_p">未读信息：<font color="red"><a href="#">0&nbsp;&nbsp;<%-- ${sessionScope.user.messageCount } --%></a></font>条</p>

	<p class="info_p">昵称：
		<input  readonly="readonly" type="text" name="user.account" class="input4" value="${sessionScope.user.account}"/>
	</p>
	<p class="info_p">注册邮箱：
		<input  readonly="readonly" type="text" class="input4" value="${sessionScope.user.email}"/>
	</p>
	<p class="info_p">邮寄地址： 
		<input  readonly="readonly" type="text" class="input4" value="${sessionScope.user.postAddress}"/>
	</p>
	<p class="info_p">账户余额：
		<font color="red">￥ ${sessionScope.user.money }</font>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<a href="${pageContext.request.contextPath }/user/recharge.jsp">账户充值</a>
	</p>
	<c:if test="${requestScope.times=='1' }">
		<div style="text-align: center;">
			<p style="color: red; font-size: 18pt;"><b>${sessionScope.moneyMsg }</b></p>
		</div>	
	</c:if>
	<div style="margin-left: 100px;">
		<a href="BookAction!listAllBook" style="color: red;font-size: 12pt;">返回商城</a>
	</div>
</div>
<!-- 显示个人基本信息结束 -->
<!-- 修改头像开始 -->
<div class="info_right">
<form action="#" enctype="multipart/form-data" id="updatePhotoForm" method="post">
<!--  
	<a href="javascript:void(0);" class="btn_addPic"><span><em>+</em>添加图片</span><input tabindex="3" title="支持jpg、jpeg、gif、png格式，文件小于5M" size="3" name="pic" class="filePrew" type="file"></a>
-->
	
	<input type="hidden" value="<%-- ${sessionScope.user.uid } --%>" id="user_id" name="uid"/> 
	<a href="#" class="btn7 mini_btn" style="float:right; position:absolute; right:40px;" onclick="uploadPhoto()">完成</a>
</form>
<p class="info_p" style="padding-left:22px;">当前头像&nbsp;&nbsp;<a href="#">点击修改</a></p>
<div class="user_header curved"><a href="javascript:;" onclick="changePhoto()">
<img src="${pageContext.request.contextPath }/upload/user/user.jpg"  width="200px" height="200px;" title="点击修改头像" alt="我的头像"/>
</a></div>
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
