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
	<h1>controller02�� ������ color.jsp</h1>
	���޹��� �۾� ��: <%=w_color %><br>
	���޹��� ��� ��: <%=bg_color %><br>
	
	
	<h2>EL�� ����غ���</h2>
	���޹��� �۾� ��: ${w_color}<br>
	���޹��� ��� ��: ${bg_color}<br>
	���⼭ �߰��� ��� : ${apple}<br>
	
</body>
</html>