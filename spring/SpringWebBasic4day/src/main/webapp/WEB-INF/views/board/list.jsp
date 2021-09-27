<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<c:if test="${articles.size() <=0}" >
	<p>게시물이 존재하지 않습니다.</p>
</c:if>

<c:if test="${articles.size()>0}">
	<h2>게시글 목록</h2>
	<table border="1">
		<tr>
			<td>번호</td>
			<td>작성자</td>
			<td>제목</td>
			<td>비고</td>
		</tr>
		
		<c:forEach var="article" items="${articles}" varStatus="num">
			<tr>
				<td>${num.index+1}</td>
				<td>${article.writer}</td>
				<td><a href="/board/content?boardNo=${num.index+1}">${article.title}</a></td>
				<td><a href="/board/delete?boardNo=${num.index+1}">삭제</a></td>
			</tr>
		</c:forEach>
	</table>
</c:if>
	<p>
		<a href="/board/write">게시글 작성하기</a>
		<a href="/board/list">게시글 목록</a>
		
	</p>
</body>
</html>