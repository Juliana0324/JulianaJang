<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ page import="lab.web.model.EmpVO" import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
tr:nth-child(even){
	background-color:sky-blue;
}
</style>
<title>목록조회 페이지</title>
</head>
<body>
	<h1>Employees list</h1>
	<a href="/JDBC/Emp.do?action=list&num=1"><input type=button value="급여순 정렬"></a>
	<a href="/JDBC/Emp.do?action=list&num=2"><input type=button value="부서별 정렬"></a>
	<table border="1">
		<td>사원번호</td>
		<td>이름</td>
		<td>성</td>
		<td>이메일</td>
		<td>연락처</td>
		<td>입사일</td>
		<td>직무</td>
		<td>급여</td>
		<td>보너스율</td>
		<td>매니저</td>
		<td>부서</td>
<c:forEach var="emp" items="${list}">
<tr>
<td><a href="/JDBC/Emp.do?action=view&empId=${emp.employeeId }">${ emp.employeeId}</a></td>
<td>${emp.firstName}</td>
<td>${emp.lastName }</td>
<td>${emp.email }</td>
<td>${emp.phoneNumber }</td>
<td>${emp.hireDate }</td>
<td>${emp.jobId }</td>
<td>${emp.salary }</td>
<td>${emp.commissionPct }</td>
<td>${emp.managerId }</td>
<td>${emp.departmentId }</td>
</tr>
</c:forEach>
</table>
</body>
</html>