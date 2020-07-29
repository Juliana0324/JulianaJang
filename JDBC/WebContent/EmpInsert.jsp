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
<title>사원정보 <%=request.getAttribute("message") %></title>
</head>
<body>
<%EmpVO emp=(EmpVO)request.getAttribute("emp"); %>
<h1>사원정보 <%=request.getAttribute("message") %></h1>
<form action="/JDBC/Emp.do" method=post>
<input type=hidden name=action value=<%=request.getAttribute("action") %>>
<table border=1>
<%if(emp==null){ %>
<tr>
<td>사원번호 </td><td><input type="text" name =empId></td>
</tr>
<tr><td>이름,성 </td><td><input type="text" name =firstName> 
<input type="text" name =lastName>
</td></tr>
<tr><td>이메일 </td><td><input type="text" name =email></td></tr>
<tr><td>연락처 </td><td><input type=text name =phoneNumber ></td></tr>
<tr><td>입사일 </td><td><input type=date name =hireDate></td></tr>

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
<tr><td>보너스율</td><td><input type=number min=0 mas=0.99 step=0.05 name=commissionPct ></td></tr>

<tr>
<%List<EmpVO> manList =(List<EmpVO>)request.getAttribute("manList"); %>
<td>매니저</td>
<td><select name=man>
<%for (EmpVO man : manList){ %>
	<option value=<%=man.getEmployeeId() %>><%=man.getFirstName() %>

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
<%}else{ %>

<tr>
<td>사원번호 </td><td><input type="text" name =empId value=<%=emp.getEmployeeId() %>></td>
</tr>
<tr><td>이름,성 </td><td><input type="text" name =firstName value=<%=emp.getFirstName() %>> 
<input type="text" name =lastName value=<%=emp.getLastName() %>>
</td></tr>
<tr><td>이메일 </td><td><input type="text" name =email value=<%=emp.getEmail() %>></td></tr>
<tr><td>연락처 </td><td><input type=text name =phoneNumber value=<%=emp.getPhoneNumber() %>></td></tr>
<tr><td>입사일 </td><td><input type=date name =hireDate value=<%=emp.getHireDate() %>></td></tr>

<tr>
<%List<JobVO> jobList =(List<JobVO>)request.getAttribute("jobList"); %>
<td>직무 </td>
<td><select name=jobId>
<%for (JobVO job : jobList){ %>
	<option value=<%=job.getJobId() %> <%=emp.getJobId().equals(job.getJobId()) ? "selected" : ""%>><%=job.getJobTitle() %>
<%} %>
</select>
</td></tr>

<tr><td>급여</td><td><input type=text name =salary value=<%=emp.getSalary() %>></td></tr>
<tr><td>보너스율</td><td><input type=number min=0 mas=0.99 step=0.05 name=commissionPct value=<%=emp.getCommissionPct() %>></td></tr>

<tr>
<%List<EmpVO> manList =(List<EmpVO>)request.getAttribute("manList"); %>
<td>매니저</td>
<td><select name=man>
<%for (EmpVO man : manList){ %>
	<option value=<%=man.getEmployeeId() %> <%=emp.getManagerId()==man.getEmployeeId() ? "selected": "" %>><%=man.getFirstName() %>

<%} %>
</select>
</td></tr>

<tr>
<%List<DepartmentVO> deptList =(List<DepartmentVO>)request.getAttribute("deptList"); %>
<td>부서</td>
<td><select name=dept>
<%for (DepartmentVO dept : deptList){ %>
	<option value=<%=dept.getDepartmentId() %> <%=emp.getDepartmentId()==dept.getDepartmentId() ? "selected": "" %>><%=dept.getDepartmentName() %>
<%} %>
</select>
</td></tr>
<%} %>
<tr><td colspan=2>
<input type=submit value=<%=request.getAttribute("message") %>>
<input type=reset value="취소">
</td></tr>
</table>
</form>
</body>
</html>