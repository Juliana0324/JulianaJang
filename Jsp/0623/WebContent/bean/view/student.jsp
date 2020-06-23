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
<h3>학생정보 </h3>
	<ul>
		<li>이름 ${name }</li>
		<li>나이 ${age }살</li>
		<li>국어 ${kor }</li>
		<li>수학 ${math }</li>
		<li>영어 ${eng }</li>
	
	</ul>

</body>
</html>