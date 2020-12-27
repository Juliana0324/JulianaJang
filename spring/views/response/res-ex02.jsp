<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="<c:url value='/response/join'/>" method="post">
		<fieldset>
			<legend>회원가입양식</legend>
			<p>
				#	Id:<input type="text" name="userId" size="10"><br>
				#	PW:<input type="password" name="userPw" size="10"><br>
				#	Name:<input type="text" name="Name" size="10"><br>
				# 	Hobby:
				<input type="checkbox" name="hobby" value="soccer"> 축구 &nbsp;
				<input type="checkbox" name="hobby" value="book"> 독서 &nbsp;
				<input type="checkbox" name="hobby" value="music"> 음악감상 &nbsp;
				<br>
				<input type="submit" value="확인">
			</p>
		</fieldset>
	
	</form>
</body>
</html>