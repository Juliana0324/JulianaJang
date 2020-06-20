<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
<%
	String w_color=request.getParameter("word_color");
	String bg_color=request.getParameter("bg_color");


%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>controller03.jsp</title>
<style>
body{
	color: <%= w_color%>;
	background-color:<%= bg_color%>;

}
</style>
</head>
<body>
	<h1>한페이지에서 처리와 뷰를 모두 생성한 controller01</h1>
	전달 받은 배경 색: <%= bg_color%> 
	전달 받은 글씨 색: <%= w_color%> 
</body>
</html>