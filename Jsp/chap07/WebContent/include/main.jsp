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
	<h3>Main������</h3>
	<p>include�� forward�� ���������� include�Ϸ��� �������� request�� �����Ѵ�<br></p>
	<p> �� ��, request��ü�� ���޹��� �ش� jsp�������� ó������� ���� �������� ���Խ�Ų��.<br></p>
	
	<jsp:include page="./sub01.jsp"/>
	<jsp:include page="./sub02.jsp">
		<jsp:param name="name" value="ȫ�浿"/>
	</jsp:include>
	
</body>
</html>