<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<div class="tools" >
<div class="tools_content">

<p class="tools_left">
欢迎来到大象旧书网&nbsp;&nbsp;

亲爱的 <font color="red">${sessionScope.admin.account}</font>

</p>
</div>
<input type="hidden" value="${sessionScope.admin.adminId }"/>
</div>
	
	<div style="margin: 0 auto;">
		<div class="logo_content" style="background-color: #cddea7;">
			<a href="${pageContext.request.contextPath}/index.jsp" class="logo_bg"><img src="/DXbook/images/logo.png" /></a>
			<a href="#" class="adv_b1"><img src="/DXbook/images/a1.png" /></a>
		</div>
		<div class="nav_all">
			<p class="nav_content">	
			&nbsp;
			</p>
		</div>	
	</div>
</body>
</html>