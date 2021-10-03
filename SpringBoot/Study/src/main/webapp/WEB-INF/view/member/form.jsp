<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>회원가입 양식</title>
</head>
<body>
	<form action="/insert" method="post">
		<fieldset>
			<legend>회원가입 양식</legend>
			<p>
				ID: <input type="text" name = "memberId" size="10"><br>
				이름: <input type="text" name="memberName" size="10"><br>
				나이: <input type="text" name="memberAge" size="10"><br>
				주소: <input type="text" name="memberAdd" size="10"><br>
				성별: 
				<input type="radio" name="memberGender" value="1">남성
				<input type="radio" name="memberGender" value="2">여성
			<br>
			<input type="submit" value="회원가입">
			</p>
		</fieldset>
	</form>
</body>
</html>