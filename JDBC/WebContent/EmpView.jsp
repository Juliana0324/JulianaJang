<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="lab.web.model.EmpVO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상세 정보 페이지</title>
</head>
<body>
<%EmpVO emp=(EmpVO)request.getAttribute("emp"); %>
<table border="1">
<tr>
<td>사원번호</td><td><%=emp.getEmployeeId() %></td>
<td>이름</td><td><%=emp.getFirstName() %></td>
<td>성</td><td><%=emp.getLastName() %></td>
<td>이메일</td><td><%=emp.getEmail() %></td>
<td>핸드폰번호</td><td><%=emp.getPhoneNumber() %></td>
<td>입사일</td><td><%=emp.getHireDate() %></td>
<td>직무</td><td><%=emp.getJobId() %></td>
<td>급여</td><td><%=emp.getSalary() %></td>
<td>보너스</td><td><%=emp.getCommissionPct() %></td>
<td>매니저</td><td><%=emp.getManagerId() %></td>
<td>부서</td><td><%=emp.getDepartmentId() %></td>

</table>
</body>
</html>