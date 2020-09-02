<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쿠키 페이지</title>
</head>
<body>
<%Cookie[] cookie =request.getCookies();
if(cookie !=null){
	for(Cookie c : cookie){
%>
<%=c.getDomain() %>&nbsp;&nbsp; <%=c.getName() %>&nbsp;&nbsp;<%=c.getValue() %>
<br>
<%} %>
<%} %>
</body>
</html>