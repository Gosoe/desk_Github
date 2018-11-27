<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% 
	String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理员登录</title>
<script type="text/javascript" src="<%=path %>/js/jquery-1.8.3.js" ></script>
<script type="text/javascript" src="<%=path %>/js/login.js" ></script>
<link  rel="stylesheet" type="text/css" href="<%=path %>/css/global.css" />
<link  rel="stylesheet" type="text/css" href="<%=path %>/css/login.css" />
</head>
<body>
<div class="control_header">
<img src="<%=path %>/images/logo.png"  style="float:left; margin-top:13px; margin-left:20px;"/>
</div>

<div class="content">
	<div class="loginDiv">
		<div class="tag">
		<h1 class="loginTitle">管理员登录</h1>
		</div>
	
		<div class="tagContent"><br /><br />
			<div class="taglogin">
			  <form action="AdminAction!login"  method="post">
			    <table width="390" cellpadding="0" cellspacing="0">
			      <tr>
			        <td height="24"class="loginFont" colspan="2">
						<h4 class="loginTitle"><font color="red">${sessionScope.msg}</font></h4>
			        </td>
			      </tr>
			      <tr>
			        <td width="60" height="44" align="right"  class="loginFont">帐号</td>
			        <td width="317" height="44" align="left">
			          <input type="text" name="admin.account"class="input1"/></td>
			      </tr>
			      <tr>
			        <td width="60" height="44" align="right"  class="loginFont">密码</td>
			        <td height="44" align="left">
			          <input type="password" name="admin.password" class="input1"/></td>
			      </tr>
				
			      <tr>
			        <td width="60" height="50">&nbsp;</td>
			        <td height="50" align="left" >
			        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			        	<input type="submit" class="btn3" value="登录" />
			        </td>
			      </tr>
			    </table>
			  </form>
			</div>
		</div>
	</div>
	</div>

<div class="footer" style="margin-bottom: 10px;">
<%@include file="../share/footer.jsp" %>
</div>
	
</body>
</html>