<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	request.setCharacterEncoding("EUC-KR");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Main.jsp</title>
</head>
<body>
	<h3>Main페이지</h3>
	<p>include는 forward와 마찬가지로 include하려는 페이지에 request를 전달한다<br></p>
	<p> 그 후, request객체를 전달받은 해당 jsp페이지의 처리결과를 현재 페이지에 포함시킨다.<br></p>
	
	<jsp:include page="./sub01.jsp"/>
	<jsp:include page="./sub02.jsp">
		<jsp:param name="name" value="홍길동"/>
	</jsp:include>
	
</body>
</html>