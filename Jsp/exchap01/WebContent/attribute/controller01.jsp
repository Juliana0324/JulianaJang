<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<% 
    String w_color=request.getParameter("word-color");
    String bg_color=request.getParameter("bg-color");
   %> 
    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>controller01.jsp</title>
<style>
body{
	background-color: <%=bg_color%>;
	color: <%= w_color%>;
}
</style>

</head>
<body>
	<h1>������������ ó���� </h1>
	���޹��� �۾���: <%=w_color %>
	���޹��� ����: <%=bg_color %>
</body>
</html>