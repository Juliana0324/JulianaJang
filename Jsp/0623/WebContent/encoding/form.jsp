<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!-- 
	contentType�� ���ڵ� ����
		- JSP ���������� ������ HTML������ ĳ���� �� ����
		- response���� ����  character set
		
	pageEncoding�� ���ڵ� ����
		- JSP�ڵ尡 JAVA�ڵ�� ��ȯ�ɶ� ����� charset����
		- JAVA�ڵ��� character set
 -->


<!DOCTYPE html>
<html>
<head>
<!-- html�� ���ڵ� ����
	- meta charset==>���⿡ ����� ���ڵ� ������� �� �������� ������ �ؼ� 
	- Ŭ���̾�Ʈ�� ������������ �� ������ �ؼ��Ҷ� ����� ���ڵ� Ÿ���� ����
	- response�� ���� ����  character set
	
 -->
<meta charset="EUC-KR">
<title>form</title>
</head>
<body>
<h3>GET���</h3>
	<form action="control.jsp" method="GET">
		<input name="test" value="ȫ�浿"><input type="submit">
	</form>
	
<h3>POST���</h3>
	<form action="control.jsp" method="POST">
		<input name="test" value="ȫ�浿"><input type="submit">
	</form>

</body>
</html>