<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h3>������� �������� �����ϼ���</h3>
	<form action="control.jsp" method="GET">
		<select name="pageNum">
			<option value="1" selected>������1</option>
			<option value="2">������2</option>
			<option value="3">������3</option>
		</select>
		<input type="submit" value="��Ʈ�ѷ��� ��û ���� ">
	</form>
	
	<!-- redirect�� �ٸ��� -->
	<h3>redirect</h3>
	<form action="control2.jsp" method="GET">
		<select name="pageNum">
			<option value="1" selected>������1</option>
			<option value="2">������2</option>
			<option value="3">������3</option>
		</select>
		<input type="submit" value="��Ʈ�ѷ��� ��û ���� ">
	</form>
	<!-- a�ױ׷� �Ȱ��� ��û ������ -->
<a href="./control.jsp?pageNum=1">1.jsp</a> <br>
<a href="./control.jsp?pageNum=2">2.jsp</a> <br>
<a href="./control.jsp?pageNum=3">3.jsp</a> <br>
<a href="./control.jsp?pageNum=404">404.jsp</a> <br>

	<h3>servlet=forward</h3>
	<form action="/chap01/forward" method="GET">
		<select name="pageNum">
			<option value="1" selected>������1</option>
			<option value="2">������2</option>
			<option value="3">������3</option>
		</select>
		<input type="submit" value="��Ʈ�ѷ��� ��û ���� ">
	</form>
		<h3>redirect-servlet</h3>
	<form action="/chap01/redirect" method="GET">
		<select name="pageNum">
			<option value="1" selected>������1</option>
			<option value="2">������2</option>
			<option value="3">������3</option>
		</select>
		<input type="submit" value="��Ʈ�ѷ��� ��û ���� ">
	</form>
</body>
</html>