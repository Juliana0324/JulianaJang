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
			<h1>�α��� ����</h1>
		</c:when>
		<c:when test="${login eq 'fail' }">
			<h1>�α��� ����</h1>
		</c:when>
		
	</c:choose>
</body>
</html>