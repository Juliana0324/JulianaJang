<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>search-result</title>
</head>
<body>
	<table border="1">
		<tr>
			<td>�й�</td>
			<td>����</td>
			<td>����</td>
			<td>����</td>
			<td>����</td>
			<td>���</td>
		</tr>
		
		<tr>
			<td>${stu.stuName}</td>
			<td>${stu.kor}</td>
			<td>${stu.eng}</td>
			<td>${stu.math}</td>
			<td>${stu.total}</td>
			<td>${stu.average}</td>
		</tr>
	</table>

<a href="/score/register">�ٸ� ���� ����ϱ�</a>
<a href="/score/list">���� ��ü ��ȸ</a>
<a href="/score/search">���� ���� ��ȸ</a>
</body>
</html>