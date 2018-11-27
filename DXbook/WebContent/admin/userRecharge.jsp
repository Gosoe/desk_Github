<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>充值</title>
</head>
<body>
<div class="form" style="margin-left: 200px;">
	<table border="1px" bordercolor="#dddddd" cellspacing="0px" style="text-align: center;">
		<form action="UserAction!toRechargeMoney">
			<tr>
				<td>账号：</td>
				<td>${user.account}</td>
				<input type="hidden" name="user.userId" value="${user.userId}">
			</tr>
			<tr>
				<td>充值金额：</td>
				<td><input type="text" name="addMoney"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" name="确定充值"></td>
			</tr>
		</form>
	</table>
</div>
</body>
</html>