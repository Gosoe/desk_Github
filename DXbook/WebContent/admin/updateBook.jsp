<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改图书信息</title>
<link  rel="stylesheet" href="<%=path %>/css/global.css" />
</head>
<body>
	<div class="form" style="margin: 0 auto;">
		<form action="BookAction!toUpdateBook" method="post" enctype="multipart/form-data">
		   <table border="1px" cellspacing="1px">
			    <tr style="height: 35px">
			    	<td width="70px">书名:${book.userId}</td>
			    	<td width="350px">
			    		<input type="text" name="book.name" value=${book.name} readonly="readonly"/>
			    		<font color="#dddddd">不可更改&nbsp;&nbsp;</font>
			    	</td>
			    </tr>
		    	<tr style="height: 35px">
			    	<td width="70px">作者:</td>
			    	<td width="300px">
			    		<input type="text" name="book.author" value=${book.author} readonly="readonly"/>
			    		<font color="#dddddd">不可更改&nbsp;&nbsp;</font>
			    	</td>
			    </tr>
		    	<tr style="height: 35px">
			    	<td width="70px">图书类型:</td>
			    	<td width="300px">
			    		<input type="text" name="book.bookType" value=${book.bookType} readonly="readonly">
			    		<font color="#dddddd">不可更改&nbsp;&nbsp;</font>
			    	</td>
			    </tr>
				<tr style="height: 35px">
			    	<td width="70px">补充说明:</td>
			    	<td width="300px">
			    		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			    		<textarea rows="4" cols="40" name="book.brief" value=${book.brief} readonly="readonly"></textarea>
			    	</td>
			    </tr>
			    <tr style="height: 35px">
			    	<td width="70px">数量:</td>
			    	<td width="300px">
			    		<input type="text" name="book.storage" value=${book.storage}>
			    		<font color="red">*(可更改)&nbsp;&nbsp;</font>
			    	</td>
			    </tr>
			    <tr style="height: 35px">
			    	<td width="70px">原价:</td>
			    	<td width="300px">
			    		<input type="text" name="book.costPrice" value=${book.costPrice} readonly="readonly">
			    		<font color="#dddddd">不可更改&nbsp;&nbsp;</font>
			    	</td>
			    </tr>
			    <tr style="height: 35px">
			    	<td width="70px">现出售价:</td>
			    	<td width="300px">
			    		<input type="text" name="book.nowPrice" value=${book.nowPrice}>
			    		<font color="red">*(可更改)&nbsp;&nbsp;</font>
			    	</td>
			    </tr>
			    <tr style="height: 35px">
			    	<td width="70px">上传图片:</td>
			    	<td width="300px">
			    		<input type="file" name="bookPic" disabled="disabled">
			    		<img alt="图书图片" src="upload/${book.imgPath}" width="80px" height="80px">
			    		<font color="#dddddd">*(不可更改)&nbsp;&nbsp;</font>
			    	</td>
				<tr style="height: 35px">
			    	<td colspan="2" align="center">
			    		<input type="hidden" name="book.belongToAdmin" value="1">
			    		<input type="hidden" name="book.bookId" value="${book.bookId}">
			    		<input type="submit" value="修改"></td>
			    	</td>
			    </tr>
		     </table>   
	    </form>
	</div>
</body>
</html>