<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>파라미터값 처리 문제</h1>
	<form action="/web/request/req-quiz" method="post">
		<p>
			# ID : <input type="text" name="userId" size="10"> <br>
			# PW : <input type="password" name="userPw" size="10"> <br>
			<input type="submit" value="로그인">
		</p>
	</form>


</body>
</html>