<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags"  prefix="s"%>

<div class="tools" >
<div class="tools_content">
<ul class="tools_right" >


<li><a href="${pageContext.request.contextPath}/user/uploadUserBook.jsp">上传图书</a></li>
<li><a href="UserAction!myInfo">个人信息</a></li>        <!-- ${pageContext.request.contextPath}/user/userCenter.jsp -->
<li class="tools_myBook"><a href="BookAction!myUpload">我的上传</a></li>
<li class="tools_myBook"><a href="OrderAction!myOrder">我的订单</a></li>
<li class="tools_myCard"><a href="OrderAction!myShoppingHistory">已付款</a></li>


<li><a href="#">投诉与建议</a></li>
<li><a href="#">大象服务</a></li>
</ul>
<p class="tools_left">
欢迎来到大象旧书网&nbsp;&nbsp;
<s:if test="#session.user==null">
<a href="${pageContext.request.contextPath}/user/login.jsp">登录</a>&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/user/register.jsp">免费注册</a>
</s:if>
<s:else>
亲爱的<a href="${pageContext.request.contextPath}/user/userCenter.jsp" ><font color="#00F"><s:property value="#session.user.account"/></font></a>你好&nbsp;&nbsp;
</s:else>
&nbsp;&nbsp;&nbsp;&nbsp;
<a href="BookAction!listAllBook" style="color: red;font-size: 12pt;">返回商城</a>
</p>
</div>
<input type="hidden" value="${sessionScope.user.userId}" id="userid"/>
</div>



<div class="logo_content" style="background-color: #cddea7;">
	<a href="${pageContext.request.contextPath}/user/uploadUserBook.jsp" class="logo_bg">
		<img src="/DXbook/images/logo.png" />
	</a>
	<a href="${pageContext.request.contextPath}/user/uploadUserBook.jsp" class="adv_b1"><img src="/DXbook/images/a1.png" /></a>
</div>

<div class="nav_all">
<p class="nav_content">
<a href="javascript:;" class="search-type">特价图书</a>
<a href="javascript:;" class="search-type">在线阅读</a>
<a href="javascript:;" class="search-type"> 青春文学</a>
<a href="javascript:;" class="search-type">小说</a>
<a href="javascript:;" class="search-type"> 数据库</a>
<a href="javascript:;" class="search-type">编程语言</a>
<a href="javascript:;" class="search-type"> 艺术</a>
<a href="javascript:;" class="search-type">心理学</a>
</p>
</div>
