<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>search.jsp</title>
</head>
<body>
	<h1>�й� ã��</h1>
	<%--
	- /selectOne ��û�� ���� �ش� �й��� ���� �л��� ����������
	  ��ȸ�Ͽ� search-result.jsp���� �ش� ������ ȭ�鿡 ����ϼ���.
 --%>
 
	<form action="/score/selectOne">
		<p>
			# ã���� �й�: <input type="text" name="stuNum"> 
			<input type="submit" value="ã��">
		</p>
	</form>
	
	<p style="color:red">${msg}</p>
</body>
</html>