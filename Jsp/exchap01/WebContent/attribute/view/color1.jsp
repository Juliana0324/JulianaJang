
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
 <%
 	String w_color=(String)request.getAttribute("w_color");  
 	String bg_color=(String)request.getAttribute("bg_color"); 
   
   	
   %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<style>
body{
	background-color: <%= bg_color%>;
	color: <%= w_color%>;
}
</style>
<title>color1.jsp</title>
</head>
<body>
<h2>controller04�� ������ color1.jsp</h2>
	���޹��� �۾� ��: <%=w_color%><br>
	���޹��� ��� ��: <%=bg_color%><br>

<h2>EL�� ����غ���</h2>
	���޹��� �۾���: ${w_color }<br>
	���޹��� ����: ${bg_color }<br>
</body>
</html>