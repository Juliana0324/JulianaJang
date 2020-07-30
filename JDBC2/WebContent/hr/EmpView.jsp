<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="lab.web.model.EmpDetailVO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상세 정보 페이지</title>
</head>
<body>
<h2>사원 정보페이지</h2>
<table border="1">
<tr><td>사원번호</td><td>${emp.employeeId }</td></tr>
<tr><td>이름</td><td>${emp.firstName }</td></tr>
<tr><td>성</td><td>${emp.lastName}</td></tr>
<tr><td>이메일</td><td>${emp.email }</td></tr>
<tr><td>핸드폰번호</td><td>${emp.phoneNumber}</td></tr>
<tr><td>입사일</td><td>${emp.hireDate }</td></tr>
<tr><td>직무</td><td>${emp.jobTitle }(${emp.jobId })</td></tr>
<tr><td>급여</td><td>${emp.salary }</td></tr>
<tr><td>보너스</td><td>${emp.commissionPct }</td></tr>
<tr><td>매니저</td><td>${emp.managerName }(${emp.managerId })</td></tr>
<tr><td>부서</td><td>${emp.departmentName }(${emp.departmentId})</td></tr>
</table>
<a href="/JDBC/Emp.do?action=update&empId=${emp.employeeId}">정보수정</a>&nbsp;&nbsp;
<a href="">정보삭제</a>&nbsp;&nbsp;

</body>
</html>