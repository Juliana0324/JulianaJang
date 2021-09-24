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
			<legend>회원가입 양식</legend>
			<p>
				-ID: <input type="text" name="userId" size="10"><br>
				-PW: <input type="password" name="userPw" size="10"><br>
				-NAME: <input type="text" name="userName" size="10"><br>
				
				-Hobby:
				<input type="checkbox" name="hobby" value="soccer">축구<br>
				<input type="checkbox" name="hobby" value="boxing">복싱<br>
				<input type="checkbox" name="hobby" value="music">음악<br>
				
				<input type="submit" value="회원가입">
			</p>	
		</fieldset>
	</form>
</body>
</html>