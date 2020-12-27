<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>점수 등록 성공</title>
</head>
<body>
	<p>
		<a href="<c:url value='/score/register'/>">다른점수 등록하기(add another score)</a>
		<a href="<c:url value='/score/list'/>">점수 전체조회(All score)</a>
		<a href="<c:url value='/score/search'/>">개별점수 조회(individual score)</a>
	</p>
</body>
</html>