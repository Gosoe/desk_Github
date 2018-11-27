<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>上传图书</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/jquery-ui-1.10.2.custom.css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/global.css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/controlContent.css" />
</head>
<body>
	<%@ include file="../share/header.jsp" %>
	<div class="form">
		<form action="BookAction!uploadUserBook" method="post" enctype="multipart/form-data">
		   <table border="1px" cellspacing="1px">
			    <tr style="height: 35px">
			    	<td width="70px">书名:</td>
			    	<td width="350px">
			    		<input type="text" name="book.name" />
			    		<font color="red">*(必填)&nbsp;&nbsp;</font>
			    	</td>
			    </tr>
		    	<tr style="height: 35px">
			    	<td width="70px">作者:</td>
			    	<td width="300px">
			    		<input type="text" name="book.author" />
			    		<font color="red">*(必填)&nbsp;&nbsp;</font>
			    	</td>
			    </tr>
		    	<tr style="height: 35px">
			    	<td width="70px">图书类型:</td>
			    	<td width="300px">
			    		<input type="text" name="book.bookType">
			    		<font color="red">*(必填)&nbsp;&nbsp;</font>
			    	</td>
			    </tr>
				<tr style="height: 35px">
			    	<td width="70px">补充说明:</td>
			    	<td width="300px">
			    		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			    		<textarea rows="4" cols="40" name="book.brief"></textarea>
			    	</td>
			    </tr>
			    <tr style="height: 35px">
			    	<td width="70px">数量:</td>
			    	<td width="300px">
			    		<input type="text" name="book.storage" value=1>
			    		<font color="red">*(必填)&nbsp;&nbsp;</font>
			    	</td>
			    </tr>
			    <tr style="height: 35px">
			    	<td width="70px">原价:</td>
			    	<td width="300px">
			    		<input type="text" name="book.costPrice" value=0>
			    		<font color="red">*(必填)&nbsp;&nbsp;</font>
			    	</td>
			    </tr>
			    <tr style="height: 35px">
			    	<td width="70px">现出售价:</td>
			    	<td width="300px">
			    		<input type="text" name="book.nowPrice" value=0>
			    		<font color="red">*(必填)&nbsp;&nbsp;</font>
			    	</td>
			    </tr>
			    <tr style="height: 35px">
			    	<td width="70px">上传图片:</td>
			    	<td width="300px">
			    		<input type="file" name="bookPic">
			    		<font color="red">*(必填)&nbsp;&nbsp;</font>
			    	</td>
			    </tr>	
				<tr style="height: 35px">
			    	<td colspan="2" align="center">
			    		<input type="hidden" name="book.belongToAdmin" value="0">
			    		<input type="submit" value="上传"></td>
			    	</td>
			    </tr>
		     </table>   
	    </form>
	</div>

</body>
</html>