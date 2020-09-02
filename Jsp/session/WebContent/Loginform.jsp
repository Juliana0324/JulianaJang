<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 폼</title>
</head>
<body>
<% String userid=(String)session.getAttribute("userid");
	if (userid == null){
%>
<h1>로그인 폼</h1>
<form action="./login" method="post">
아이디: <input type="text" name="userid"><br>
비밀번호: <input type="password" name="pwd"><br>
<input type="hidden" name="action" value="login">
<input type="submit" value="로그인">&nbsp
<input type="reset" value="취 소">
</form>
아이디가 없다면? 
<a href="./memberform.jsp">회원가입</a>하세요
<%} else{
	response.sendRedirect("./mypage.jsp");
}%>
</body>
</html>