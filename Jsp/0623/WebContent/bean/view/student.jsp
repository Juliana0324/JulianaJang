<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <% 
    String name=(String)request.getAttribute("name");
	String age=(String)request.getAttribute("age");
    int kor= (int)(request.getAttribute("kor"));
    String eng= (String)(request.getAttribute("eng"));
    String math= (String)(request.getAttribute("math"));
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>controller02</title>
</head>
<body>
<h3>�л����� </h3>
	<ul>
		<li>�̸� ${name }</li>
		<li>���� ${age }��</li>
		<li>���� ${kor }</li>
		<li>���� ${math }</li>
		<li>���� ${eng }</li>
	
	</ul>

</body>
</html>