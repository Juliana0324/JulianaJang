<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사원 검색</title>
</head>
<body>
<h3>검색하려는 사원의 사원번호를 입력하세요</h3>
<form action="/JDBC/Emp.do">
<input type=hidden name=action value=view>
사원번호: <input type=text name=empId>
&nbsp;&nbsp;<input type=submit value="검색">
</form>
</body>
</html>