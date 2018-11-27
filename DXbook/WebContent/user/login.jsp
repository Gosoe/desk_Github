<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>用户登录</title>
<script type="text/javascript" src="<%=path %>/js/jquery-1.8.3.js" ></script>
<script type="text/javascript" src="<%=path %>/js/login.js" ></script>
<link  rel="stylesheet" href="<%=path %>/css/global.css" />
<link  rel="stylesheet" href="<%=path %>/css/login.css" />
</head>

<body>
<div class="control_header">
<img src="<%=path %>/images/logo.png"  style="float:left; margin-top:13px; margin-left:20px;"/>
</div>

<div class="content">
<div class="loginDiv">
<div class="tag">
<h1 class="loginTitle">欢迎登录</h1>

</div>

<div class="tagContent" style="height: 400px;"><br /><br />
<div class="taglogin" style="height: 400px;">
  <form action="UserAction!login"  method="post">
    <table width="390" cellpadding="0" cellspacing="0">
      <tr>
        <td height="40"class="loginFont" colspan="2">
			<h4 class="loginTitle"><font color="red">${sessionScope.msg}</font></h4>
        </td>
      </tr>
      <tr>
        <td width="60" height="40" align="right"  class="loginFont">帐号</td>
        <td width="317" height="40" align="left">
          <input type="text" name="user.account"class="input1"/></td>
      </tr>
      <tr>
        <td width="60" height="40" align="right"  class="loginFont">密码</td>
        <td height="40" align="left">
          <input type="password" name="user.password" class="input1"/></td>
      </tr>
	  
      <tr>
        <td width="60" height="45">&nbsp;</td>
        <td height="50" align="left" >
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        	<input type="submit" class="btn3" value="登录" />
        	&nbsp;&nbsp;&nbsp;还不是会员？&nbsp;
        	<a href="register.jsp">申请注册</a>
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
