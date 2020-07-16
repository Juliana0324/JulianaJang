<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Input Result</title>
</head>
<body>
	<h2>내장 객체</h2>
	<% request.setCharacterEncoding("UTF-8"); %>
	이름: <%=request.getParameter("name") %><br>
	연락처: <%=request.getParameter("tel") %>
</body>
</html>