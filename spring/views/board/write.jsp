<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>게시글 등록</h2>
	<form method="post">
		<p>
			#작성자 : <input name="writer"><br>
			<br>
			
			#제목 : <input name="title"><br>
			<br>
			#내용 : <textarea row="3" name="content"></textarea>
			<br>
			<input type="submit" value="등록">
		</p>
	</form>
</body>
</html>