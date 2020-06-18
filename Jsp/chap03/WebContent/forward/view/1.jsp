<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>1.jsp</h1>
	<p>select.jsp에서 요청하신 페이지는 
	<%=request.getParameter("pageNum") %>입니다.</p>
</body>
</html>