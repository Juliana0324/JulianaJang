<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>form.jsp</title>
</head>
<body>
<h5>��Ʈ�ѷ� 1�� ������!</h5>
<form action="./controller03.jsp">
	�۾� ��: <input type="color" name="word_color" value="#ffffff"><br>
	��� ��: <input type="color" name="bg_color" value="#000000"><br>
	<input type="submit" value="����!"><br>
</form>

<h5>��Ʈ�ѷ� 2�� ������!</h5>
<form action="./controller04.jsp">
	�۾��� : <input type="color" name="word_color" value="#f000f0"><br>
	���� : <input type="color" name="bg_color" value="#0000ff"><br>
	<input type="submit" value="����!">
</form>
</body>
</html>