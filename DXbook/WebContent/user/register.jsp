<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags"  prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>用户注册</title>
<script type="text/javascript" src="../js/jquery-1.8.3.js" ></script>
<script type="text/javascript" src="../js/register.js" ></script>
<link  rel="stylesheet" href="../css/global.css" />
<link  rel="stylesheet" href="../css/register.css" />
</head>

<body>
<div class="control_header">
<img src="<%=path %>/images/logo.png"  style="float:left; margin-top:13px; margin-left:20px;"/>
</div>


<div class="content">
<div class="register_div">
<div class="register_head"><p>注册新用户</p></div>
<div class="register_body">
<form action="UserAction!register" method="post" id="register_form">
  <table width="958" border="1px" cellspacing="0" id="register_table">
	<tr>
      <td class="t">账号：</td>
      <td width="293px"><input type="text" name="user.account" class="input1"/></td>
      <td  class="account_span" style="color:red;text-align: left;">*必填</td>
    </tr>
    <tr>
      <td class="t">登录密码：</td>
      <td><input type="password" name="user.password" id="password"  class="input1" /></td>
      <td class="password_span" style="text-align: left;">密码为6-20个字符,可由英文、数字及符号组成</td>
    </tr>
    <tr>
      <td class="t">确认密码：</td>
      <td><input type="password" name="rpassword" id="rpassword"  class="input1"/></td>
      <td class="rpassword_span" style="text-align: left;">请再次输入密码</td>
    </tr>
	<tr>
      <td class="t">真实姓名：</td>
      <td><input type="text" name="user.name" class="input1"/></td>
      <td  class="account_span" style="color:red;text-align: left;">*必填</td>
    </tr>
	<tr>
      <td class="t">性别：</td>
      <td>
		<input type="radio" name="user.sex" value="男"/>男
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="radio" name="user.sex" value="女"/>女
      </td>
      <td  class="account_span" style="color:red;text-align: left;">*必填</td>
    </tr>
	<tr>
      <td class="t">身份证号：</td>
      <td><input type="text" name="user.IDCard" class="input1"/></td>
      <td  class="account_span" style="color:red;text-align: left;">*必填</td>
    </tr>
   <tr>
      <td class="t">邮寄地址：</td>
      <td><input type="text" name="user.postAddress" class="input1"/></td>
      <td  class="account_span" style="color:red;text-align: left;">*必填</td>
    </tr>
    <tr>
      <td class="t">邮政编码：</td>
      <td><input type="text" name="user.postCode" class="input1"/></td>
      <td  class="account_span" style="color:red;text-align: left;"></td>
    </tr>
    <tr>
    <td class="t">邮箱：</td>
      <td><input type="text" name="user.email" class="input1"/></td>
      <td  class="account_span" style="color:red;text-align: left;">*必填</td>
    </tr>
    
    <input type="hidden" name="user.money" value=0 />
    <input type="hidden" name="user.isAdmin" value="0"/>
    
    <tr >
      <td class="t">&nbsp;</td>
      <td><input type="submit" id="register_btn" value=""/></td>
      <td style="text-align: left;">已有帐号?&nbsp;&nbsp;<a href="login.jsp">立即登录</a></td>
    </tr>
   
  </table>
 </form>
</div>
</div>
</div>

<div class="footer">
<div class="footer_div">
<p><a href="javascript:void(0);">公司简介</a>|<a href="javascript:void(0);">诚征英才</a>|<a href="javascript:void(0);">网站联盟</a>|<a href="javascript:void(0);">网站联盟</a>|<a href="javascript:void(0);">百货招商</a>|<a href="javascript:void(0);">官方Blog</a></p><br/>
<p>Copyright优优图书商城2004-2013,author_liaoyu，版权所有</p>
</div>
</div>
</body>
</html>
