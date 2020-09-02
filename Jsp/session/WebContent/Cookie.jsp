<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cookie</title>
</head>
<body>
<% String sessid=(String)request.getSession().getAttribute("sessid"); %>
<%if(session !=null){ %>
Cookie <%=sessid %><br><br>
SessionId <%=session.getId() %>
<br><br>
<%} %>
<a href="./Cookie">/CookieServlet</a>
<a href=/Cookie;jsessionid=<%=session.getId() %>>/Cookie(getID())</a>
</body>
</html>