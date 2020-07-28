<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="lab.web.model.*" import="java.util.*"%>

<!DOCTYPE html>
<html>
<head>
<style>
table:{ 
width: 150px;
height:50px;

}
tr:nth-child(even){
	background-color:skyblue;
}
</style>
<meta charset="UTF-8">
<title>사원정보 입력페이지</title>
</head>
<body>
<h1>사원정보 입력</h1>
<form action="/JDBC/Emp.do" method=post>
<table border=1>
<tr>
<td>사원번호 </td><td><input type="text" name =empId></td>
</tr>
<tr><td>이름,성 </td><td><input type="text" name =firstName> 
<input type="text" name =lastName>
</td></tr>
<tr><td>이메일 </td><td><input type="text" name =email></td></tr>
<tr><td>연락처 </td><td><input type=text name =phoneNumber></td></tr>
<tr><td>입사일 </td><td><input type=date name =phoneNumber></td></tr>

<tr>
<%List<JobVO> jobList =(List<JobVO>)request.getAttribute("jobList"); %>
<td>직무 </td>
<td><select name=jobId>
<%for (JobVO job : jobList){ %>
	<option value=<%=job.getJobId() %>><%=job.getJobTitle() %>
<%} %>
</select>
</td></tr>

<tr><td>급여</td><td><input type=text name =salary></td></tr>
<tr><td>보너스율</td><td><input type=number min=0 mas=0.99 step=0.05 name=commissionPct></td></tr>

<tr>
<%List<EmpVO> manList =(List<EmpVO>)request.getAttribute("manList"); %>
<td>매니저</td>
<td><select name=man>
<%for (EmpVO emp : manList){ %>
	<option value=<%=emp.getEmployeeId() %>><%=emp.getFirstName() %>
<%} %>
</select>
</td></tr>

<tr>
<%List<DepartmentVO> deptList =(List<DepartmentVO>)request.getAttribute("deptList"); %>
<td>부서</td>
<td><select name=dept>
<%for (DepartmentVO dept : deptList){ %>
	<option value=<%=dept.getDepartmentId() %>><%=dept.getDepartmentName() %>
<%} %>
</select>
</td></tr>
<tr><td colspan=2>
<input type=submit value="입력">
<input type=reset value="취소">
</td></tr>
</table>
</form>
</body>
</html>