
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
<h2>controller04로 도착한 color1.jsp</h2>
	전달받은 글씨 색: <%=w_color%><br>
	전달받은 배경 색: <%=bg_color%><br>

<h2>EL로 출력해보기</h2>
	전달받은 글씨색: ${w_color }<br>
	전달받은 배경색: ${bg_color }<br>
</body>
</html>