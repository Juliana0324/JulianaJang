<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%--
	1. ���� ��������� �޾Ƽ� �ֿܼ� ����ϴ� 
	   �޼��带 ���� (url: /birth : POST)
          ����) BirthVO Ŀ�ǵ尴ü ���, 
          �ֿܼ� ���۵� ���� �ٿ��� ����մϴ� ex)20180615
	2. birth-result.jsp �������� 
	"����� ������ ~~~~�� ~~�� ~~���Դϴ�." �� ����ϼ���
--%>

	<form action="/birth" method="POST">
		<fieldset>
			<legend>������� ��</legend>
			<p>
				# Born Year : <input type="text" name="year" size="10"><br>
				# Born Month: <input type="text" name="month" size="10"><br>
				# Born day: <input type="text" name="day" size="10"><br>
				
				<input type="submit" value="���������">
			</p>
		</fieldset>				
	</form>
</body>
</html>