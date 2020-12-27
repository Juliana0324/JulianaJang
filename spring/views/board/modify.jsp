<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>modify.jsp</title>
</head>
<body>	
	<h2>${boardNo}번 게시물 수정</h2>
	<form method="post">
		<p>
			<input type="hidden" name="boardNo" value="${boardNo}">
			# 작석자: <input type="text" name="writer" value="${article.writer}"><br>
			# 제목: <input type="text" name="title" value="${article.title}">
			# 내용: <textarea row="3" name="content">
				${article.content}</textarea>
				<br>
				<input type="submit" >
		</p>
	</form>
</body>
</html>