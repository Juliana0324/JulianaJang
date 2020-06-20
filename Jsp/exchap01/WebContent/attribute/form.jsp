<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>form.jsp</title>
</head>
<body>
	<h5>컨트롤러 1번에 보내기</h5>
	<form action="./controller01.jsp">
	글씨 색<input type="color" name="word-color" value="#ffff00"><br>
	배경 색<input type="color" name="bg-color" value="#0000ff"><br>
	<input type="submit">
	</form>
	
	<h5>컨트롤러 2번에 보내기</h5>
	<form action="./controller02.jsp">
	글씨 색<input type="color" name="word-color" value="#ffff00"><br>
	배경 색<input type="color" name="bg-color" value="#0000ff"><br>
	<input type="submit">
	</form>
	
</body>
</html>