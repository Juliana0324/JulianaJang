<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
<h1>Login</h1>
<%=request.getAttribute("message")==null ?"": request.getAttribute("message") %>
<form action="../Login.do" method=post>
아이디: <input type=text name=id><br>
비밀번호: <input type=password name=pw><br>
데이터 입력페이지로 가기: <br>
<a href="../DataMain.jsp"><input type=button value="데이터 입력페이지 가기"></a>
<input type=submit value=로그인><br>
</form>
</body>
</html>