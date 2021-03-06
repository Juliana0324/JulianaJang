<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ page import="lab.web.model.EmpVO" import="java.util.*" %>
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
		
<% List<EmpVO> list=(List<EmpVO>)request.getAttribute("list"); %>
<%for(EmpVO emp:list) {%>
<tr>
<td><a href="/JDBC/Emp.do?action=view&empId=<%=emp.getEmployeeId() %>"><%=emp.getEmployeeId() %></a></td>
<td><%=emp.getFirstName() %></td>
<td><%=emp.getLastName() %></td>
<td><%=emp.getEmail() %></td>
<td><%=emp.getPhoneNumber() %></td>
<td><%=emp.getHireDate() %></td>
<td><%=emp.getJobId() %></td>
<td><%=emp.getSalary() %></td>
<td><%=emp.getCommissionPct() %></td>
<td><%=emp.getManagerId() %></td>
<td><%=emp.getDepartmentId() %></td>
</tr>
<%} %>	
</table>
</body>
</html>