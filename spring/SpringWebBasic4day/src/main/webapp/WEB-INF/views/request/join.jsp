<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
	# 컨텍스트 루트 경로가 변경될 경우 처리방법.
	1. 컨텍스트 루트 경로를 변수로 지정함.
	2. <c:url> 태그를 사용
 --%>
<c:set var="path" value="<%= request.getContextPath() %>" scope="application"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h2>요청 파라미터값 테스트!!</h2>
<%-- 
# 1번 방식
<form action="${path}/request/join" method="post">
--%>
<%-- # 2번 방식 --%>
<form action="<c:url value='/request/join' />" method="post">
	<fieldset>
		<legend>회원가입 양식</legend>
		<p>
			- ID: <input type="text" name="userId" size="10"><br>
			- PW: <input type="password" name="userPw" size="10"><br>
			- NAME: <input type="text" name="userName" size="10"><br>
			- HOBBY:
			<input type="checkbox" name="hobby" value="soccer">축구&nbsp;
			<input type="checkbox" name="hobby" value="book">독서&nbsp;
			<input type="checkbox" name="hobby" value="music">음악&nbsp;
			<br>
			<input type="submit" value="회원가입">
		</p>
	</fieldset>
</form>

</body>
</html>


