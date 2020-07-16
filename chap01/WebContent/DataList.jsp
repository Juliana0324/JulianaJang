<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*"  import="lab.web.model.DataVO" %>
<!DOCTYPE html>
<html>
<head>
<style>
tr:nth-child(even){
	background-color:skyblue;
	color:white;
}
</style>
<meta charset="UTF-8">
<title>Data List</title>
</head>
<body>
	<% ArrayList<DataVO> list=(ArrayList<DataVO>)request.getAttribute("list"); %>
	<table border="2">
		<tr>
		<td>이름</td><td>연락처</td><td>주소</td>
		</tr>
		<% for(DataVO data:list){ %>
		<tr>
		<td><%=data.getName() %></td>
		<td><%=data.getTel() %></td>
		<td><%=data.getAdd() %></td>
		</tr>
		<%} %>
	</table>
	<form>
		<br>
		<a href="/DataSuccess.jsp">추가하기</a>
	</form>
</body>
</html>
