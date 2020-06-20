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
<title>color.jsp</title>
<style>
body{
	background-color: <%= bg_color%>;
	color:<%= w_color%>
}

</style>

</head>
<body>
	<h1>controller02로 도착한 color.jsp</h1>
	전달받은 글씨 색: <%=w_color %><br>
	전달받은 배경 색: <%=bg_color %><br>
	
	
	<h2>EL로 출력해보기</h2>
	전달받은 글씨 색: ${w_color}<br>
	전달받은 배경 색: ${bg_color}<br>
	여기서 추가한 사과 : ${apple}<br>
	
</body>
</html>