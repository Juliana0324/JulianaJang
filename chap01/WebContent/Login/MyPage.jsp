<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My Page</title>
</head>
<body>
<h2>마이페이지</h2>
<!-- 세션에 저장해 두었기 때문에 자바에서 불러오기 -->
<%if(session.getAttribute("id")!=null){ %>
안녕하세요,<%=session.getAttribute("id") %>님 환영합니다.
<a href="../Login.do"><input type=button value=로그아웃></a><br>
<% } else{response.sendRedirect("/Login/login.jsp"); } %>

</body>
</html>