<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>ȸ������ ���</title>
</head>
<body>
	<form action="/insert" method="post">
		<fieldset>
			<legend>ȸ������ ���</legend>
			<p>
				ID: <input type="text" name = "memberId" size="10"><br>
				�̸�: <input type="text" name="memberName" size="10"><br>
				����: <input type="text" name="memberAge" size="10"><br>
				�ּ�: <input type="text" name="memberAdd" size="10"><br>
				����: 
				<input type="radio" name="memberGender" value="1">����
				<input type="radio" name="memberGender" value="2">����
			<br>
			<input type="submit" value="ȸ������">
			</p>
		</fieldset>
	</form>
</body>
</html>