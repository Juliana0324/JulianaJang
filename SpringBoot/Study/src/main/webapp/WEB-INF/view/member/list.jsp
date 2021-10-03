<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>ȸ�� ��� ����¢</title>
</head>
<body>	
	<form action="/list">
	<table border="1">
		<tr>
			<td>Id</td>
			<td>Name</td>
			<td>Address</td>
			<td>Gender</td>
		</tr>
		
		<c:forEach items="${members}" var="m">
		<tr>
			<td>${m.memberId}</td>
			<td>${m.memberName}</td>
			<td>${m.memberAdd}</td>
			<td>${m.memberGender}</td>
		</tr>
		</c:forEach>
	</table>
	</form>
	
	
	<a href="/">�������� ���ư���</a>
	<a href="/insert">ȸ�� ����</a>
</body>
</html>