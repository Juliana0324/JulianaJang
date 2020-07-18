<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Data Insert Page</title>
</head>
<body>
	<h1>데이터를 입력해주세요</h1>
	<form action="../Data.do" method=post>
	이름: <input type=text name=name><br>
	연락처: <input type=text name=tel><br>
	주소: <input type=text name=add><br>
	<input type=submit value="저장">
	<input type=reset value="취소">
	</form>
</body>
</html>