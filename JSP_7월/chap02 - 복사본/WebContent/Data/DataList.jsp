<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.util.*" import="lab.module.DataVO" %>
<!DOCTYPE html>
<html>
<head>
<style>
tr:nth-child(even){
	background-color:skyblue;
	color:white;
	text: bold;
}
</style>
<meta charset="EUC-KR">
<title>Data List</title>
</head>
<body>
<% ArrayList<DataVO> list=(ArrayList<DataVO>)request.getAttribute("list"); %>
	<table border="2">
		<tr>
		<th>�̸�</th><th>����ó</th><th>�ּ�</th>
		</tr>
		<%for(DataVO data:list){ %>
		<tr>
			<td><%=data.getName() %></td>
			<td><%=data.getTel() %></td>
			<td><%=data.getAdd() %></td>
		</tr>
		<%} %>
	</table>
	<form>
		<br>
		<a href="/DataSuccess.jsp">�����߰��ϱ�</a>
	</form>
</body>
</html>