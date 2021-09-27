<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>시험 점수 등록 페이지</title>
</head>
<body>
	<h2>시험점수 등록페이지</h2>
	<form action="/score/register" method="POST">
		<p>
		# 이름: <input type="text" name="stuName"><br>
		# 국어: <input type="text" name="kor"><br>
		# 영어: <input type="text" name="eng"><br>
		# 수학: <input type="text" name="math"><br>
		
		<input type="submit" value="확인">
		</p>
	</form>
</body>
</html>