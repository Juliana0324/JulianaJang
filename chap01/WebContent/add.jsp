<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add insert</title>
</head>
<body>
	<form action="/AddData.do" method="post">
	입력하신 숫자에 추가할 숫자: <br>
	<input text=text name=num><br>
	<input type=submit value="저장">
	<input type=reset value="취소">
	</form>
</body>
</html>