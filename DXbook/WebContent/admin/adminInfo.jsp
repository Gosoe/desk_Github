<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>个人信息</title>
</head>
<body>
		<div class="form" style="margin-left: 200px;">
		<form action="AdminAction!recharge" method="post">
		   		<input type="hidden" name="admin.adminId" value="${admin.adminId}">
		   <table border="1px" bordercolor="#dddddd" cellspacing="0px" style="text-align: center;">
			    <tr style="height: 35px">
			    	<td width="70px">账号:</td>
			    	<td width="350px">
			    		${admin.account}
			    		<input type="hidden" name="admin.account" value="${admin.account}">
			    	</td>
			    </tr>
		    	<tr style="height: 35px">
			    	<td width="70px">真实姓名:</td>
			    	<td width="300px">
			    		${admin.name}
			    	</td>
			    </tr>
		    	<tr style="height: 35px">
			    	<td width="70px">性别:</td>
			    	<td width="300px">
			    		${admin.sex}
			    	</td>
			    </tr>
			    <tr style="height: 35px">
			    	<td width="70px">身份证号码:</td>
			    	<td width="300px">
			    		"${admin.IDCard}
			    	</td>
			    </tr>
			    <tr style="height: 35px">
			    	<td width="70px">邮件地址:</td>
			    	<td width="300px">
			    		${admin.postAddress}
			    	</td>
			    </tr>
			    <tr style="height: 35px">
			    	<td width="70px">邮政编码:</td>
			    	<td width="300px">
			    		${admin.postCode}
			    	</td>
			    </tr>
			    <tr style="height: 35px">
			    	<td width="70px">电子邮箱:</td>
			    	<td width="300px">
			    		${admin.email}
			    	</td>
			    </tr>
			    <tr style="height: 35px">
			    	<td width="70px">账户余额:</td>
			    	<td width="300px">
			    		${admin.money}
			    	</td>
			    </tr>
				<tr style="height: 35px">
			    	<td colspan="2" align="center">
			    		<input type="submit" value="余额充值"></td>
			    	</td>
			    </tr>
		     </table>   
	    </form>
	</div>
</body>
</html>