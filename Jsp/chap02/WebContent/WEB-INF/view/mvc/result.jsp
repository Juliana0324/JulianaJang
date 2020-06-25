<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
   <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<c:choose>
		<c:when test="${login eq 'success' }">
			<h1>로그인 성공</h1>
		</c:when>
		<c:when test="${login eq 'fail' }">
			<h1>로그인 실패</h1>
		</c:when>
		
	</c:choose>
</body>
</html>