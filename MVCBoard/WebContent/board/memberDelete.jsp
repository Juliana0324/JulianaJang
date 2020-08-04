<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="./css/default.css" media="screen">
<meta charset="UTF-8">
<title>글 삭제 화면</title>
</head>
<body>
<table class="layout">
<tr height="50">
	<td><jsp:include page="/incl/header.jsp"/></td>
</tr>
<tr height="500" valign="top">
	<td>
	<h1>회원 정보 삭제</h1>
	<h3>삭제 비밀번호 입력</h3>
	<form action='<c:url value="/Member.do"/>' method="post">
	<input type="hidden" name="action" value="${action}">
	<input type="hidden" name="userid" value="${userid}">
	<input type="password" name="password">
	<input type="submit" value="삭 제">
	</form>
	</td>
</tr>
<tr>
<td><jsp:include page="/incl/footer.jsp"/></td>
</tr>
</table>

</body>
</html>