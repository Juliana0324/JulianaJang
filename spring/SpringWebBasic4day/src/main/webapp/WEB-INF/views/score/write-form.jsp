<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>���� ���� ��� ������</title>
</head>
<body>
	<h2>�������� ���������</h2>
	<form action="/score/register" method="POST">
		<p>
		# �̸�: <input type="text" name="stuName"><br>
		# ����: <input type="text" name="kor"><br>
		# ����: <input type="text" name="eng"><br>
		# ����: <input type="text" name="math"><br>
		
		<input type="submit" value="Ȯ��">
		</p>
	</form>
</body>
</html>