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
	<h1>������������ ó���� �並 ��� ������ controller01</h1>
	���� ���� ��� ��: <%= bg_color%> 
	���� ���� �۾� ��: <%= w_color%> 
</body>
</html>