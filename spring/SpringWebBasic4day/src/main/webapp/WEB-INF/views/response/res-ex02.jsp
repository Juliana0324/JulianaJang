<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<form action="/response/join" method="POST">
		<fieldset>
			<legend>ȸ������ ���</legend>
			<p>
				-ID: <input type="text" name="userId" size="10"><br>
				-PW: <input type="password" name="userPw" size="10"><br>
				-NAME: <input type="text" name="userName" size="10"><br>
				
				-Hobby:
				<input type="checkbox" name="hobby" value="soccer">�౸<br>
				<input type="checkbox" name="hobby" value="boxing">����<br>
				<input type="checkbox" name="hobby" value="music">����<br>
				
				<input type="submit" value="ȸ������">
			</p>	
		</fieldset>
	</form>
</body>
</html>