<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>�α��� ������</title>
</head>
<body>

<c:if test="${not empty status }">
<script>
	alert('${status }');
</script>
<c:remove var="status" scope="session"/>
</c:if>

<c:if test="${empty cookie.login }">
	<h3>�α���</h3>
	<form action="./do/login.jsp" method="POST">
		<input name="user_id"> <br>
		<input type="password" name="user_pass"> <br>
		<input type="submit" value="�α���"> <a href="#">��й�ȣ ã��</a>
	</form>
</c:if>

<c:if test="${not empty cookie.login }">
		<!-- include�� ���� �ٸ� jsp�������� �ڵ带 ������ �� �ִ� -->
<c:choose>
	<c:when test="${cookie.login.value eq 1 }">
	</c:when>

	<c:when test="${cookie.login.value eq 2 }">
	</c:when>

	<c:when test="${cookie.login.value eq 3 }">
	</c:when>
	
	<c:when test="${cookie.login.value eq 4 }">
	</c:when>
	
	<c:when test="${cookie.login.value eq 5 }">
	</c:when>
</c:choose>
	<h3>���� �α��� �����̸� ������ ${cookie.login.value }�Դϴ�.</h3>
	<button onclick="location.href='./do/logout.jsp'">�α׾ƿ�</button>
	
</c:if>

</body>
</html>






