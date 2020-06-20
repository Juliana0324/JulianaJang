<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>form.jsp</title>
</head>
<body>
<h5>컨트롤러 1번 보내기!</h5>
<form action="./controller03.jsp">
	글씨 색: <input type="color" name="word_color" value="#ffffff"><br>
	배경 색: <input type="color" name="bg_color" value="#000000"><br>
	<input type="submit" value="전송!"><br>
</form>

<h5>컨트롤러 2번 보내기!</h5>
<form action="./controller04.jsp">
	글씨색 : <input type="color" name="word_color" value="#f000f0"><br>
	배경색 : <input type="color" name="bg_color" value="#0000ff"><br>
	<input type="submit" value="전송!">
</form>
</body>
</html>