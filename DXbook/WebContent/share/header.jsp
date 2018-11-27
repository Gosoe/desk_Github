<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags"  prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>大象图书交换网</title>
<link  rel="stylesheet" href="../css/global.css" />
<link  rel="stylesheet" href="../css/index.css" />
</head>
	<body>
		<%@ include file="../share/header2.jsp" %>
			<div class="nav_top">
				<div class="search_all">
					<form action="BookAction!listAllSearchBook" method="post" class="search_form">
						<input type="text" class="search_content" name="bookName" value="请输入书名搜索"/>
						<input type="submit" class="search_btn"/>
					</form>
					<c:if test="${requestScope.searchCount>0}">
						<p>共搜到&nbsp;<font color="red">${requestScope.searchCount}</font>&nbsp;条相关数据</p>
					</c:if>
				</div>
				<p class="search_help">
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;热搜：<a href="#">沉默的羔羊</a>&nbsp;&nbsp;<a href="#">德州电锯杀人狂</a>&nbsp;&nbsp;<a href="#">人间失格</a>&nbsp;&nbsp;<a href="#">人生</a>&nbsp;&nbsp;<a href="#">兄弟</a>
				</p>
			</div>
	</body>
</html>