<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>student02.jsp</title>
</head>
<body>
<h3>Bean을 사용해 전달받은 학생정보</h3>
<b>jsp:useBean,jsp:setProperty,EL을 활용하면 전달이 편해진다</b>

${student}<br>
${student.name }<br>
${student.age }<br>
${student.kor }<br>
${student.eng }<br>
${student.math }<br>
${student.avg }<br>
<hr>

</body>
</html>