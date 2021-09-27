<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 내용</title>
</head>
<body>
	<fieldset>
		<legend>${boardNo}번 게시물 내용</legend>
		<p>
			# 글 번호: ${boardNo}<br>
			# 작성자: ${article.writer}<br>
			# 제목: ${article.title}<br>
			# 내용: <textarea rows="3" readonly>${article.content}</textarea>
			
		</p>
	</fieldset>
	
	<a href="/board/list">글 목록보기</a>
	<a href="/board/modify?boardNo=${boardNo}">글 수정하기</a>
</body>
</html>