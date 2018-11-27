<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>优优图书</title>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.8.3.js" ></script>
<script src="${pageContext.request.contextPath }/js/jquery.hashchange.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath }/js/jquery.easytabs.min.js" type="text/javascript"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/global.js" ></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/pdetails.js" ></script>
<link  rel="stylesheet" href="${pageContext.request.contextPath }/css/global.css" />
<link  rel="stylesheet" href="${pageContext.request.contextPath }/css/pdetails.css" />
</head>
<body>

<%@include file="/share/header.jsp" %>

<div class="content">

<p class="bookTitle" style="display: block;margin-left: 50px;"></p>
<span style="float:left;font-size: 16pt;color: #fc6a15;">商品详情>></span>

<div class="content_right" style="margin-right: 60px;">
<div class="showPic">
	<div class="big" style="margin-top: 10px;">
		<img id="book_image" src="upload/${book.imgPath}" width="350" height="350"/>
	</div>
</div>
<div class="bookDetails">
<p>书名：<b>《${book.name}》</b></p>
<p>发布人：${book.bookOwner}</p>
<p>作 者：${book.author}</p>
<p>类型：${book.bookType}</p>
<p>售价：<s>¥${book.costPrice}</s>&nbsp;&nbsp;&nbsp;<b class="b_price item_price">¥${book.nowPrice}</b></p>
<p>库存量：${book.storage}</p>
<p>补充说明：<br>
	<textarea rows="4" cols="60"  style="text-indent: 2em;">
		${book.brief}		
	</textarea>
</p>
<div class="clear"></div>

<div class="buy_area">
	<form action="BookAction!buyBook" method="post">
	        <span class="allCount">支付总额为：<b class="b_price allPrice">¥${book.nowPrice} </b></span>
		<div class="btn_p" style="margin-left: 100px;">
			<input type="hidden" name="book.bookId" value="${book.bookId}"/>
			<input type="submit" class="btn btn_buy" value=""/>
		</div>
	</form>
</div>
</div>

</div>

</div>
<jsp:include page="../share/footer.jsp" />

</body>
</html>

