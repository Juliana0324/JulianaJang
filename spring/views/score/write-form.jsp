<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>성적 입력 페이지</title>
</head>
<body>
<h2>final score</h2>
	<form action="<c:url value='/score/register'/>" method="post">
		# Name		: <input name="stuName"><br>
		# Korean	: <input name="kor"><br>
		# English	: <input name="eng"><br>
		# Math		: <input name="math"><br>
		<input type="submit" value=" 확인">
	</form>
</body>
</html>