<%@ page import="java.sql.*" %>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	//jdbc : DB���� ������ ���� JAVA�� �����ϴ� API
	// � �����ͺ��̽����� JAVA���� ������ ���ؼ��� jdbc�� ���¿� ���� API�� �����ؾ��Ѵ�
	// ���п� �ڹ� ���α׷��ӵ��� DB������ ������� �ϰ��� �ڵ带 �ۼ���  �� �ִ�

	// ���� �⺻���� JDBC�� ����
	// 1. Ŭ���� �ε�
	// 	- ����� DB�� �����ϴ� JDBC����̹��� �ҷ��´�
	//  - Class.forName("JDBC����̹� Ŭ���� ���");
	
	Class.forName("oracle.jdbc.driver.OracleDriver");
	// 2. DriverManager Ŭ������ ���� DB���� ������ ����
 	String url="jdbc:oracle:thin:@localhost:1521:XE";
 	String user ="scott";
 	String pass="TIGER";
	
 	Connection con = DriverManager.getConnection(url,user,pass);
 	
 	//3. �޾ƿ� ������ ���� DB�� ���ϴ� ������ ����
 	// prepareStatement�� ���ϴ� �������� �غ�
 	// execute���� ���� �������� db�� ����
 	// - select���̶�� ����� setŸ������ ��ȯ�޴´�
 	// - Insert, UPDATE, DELETE��� �ٲ� ���� ������ int �� ��ȯ�Ѵ�
 	PreparedStatement pstmt = con.prepareStatement("SELECT * FROM EMP");
 	ResultSet rs=pstmt.executeQuery();
 	//request.setAttribute("emp_list",rs);
 	

 	
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>DB����</title>
<style>
	tr:nth-child(even){
	background-color: skyblue;
	}
	th{
	background-color: purple;
	color:white}
</style>
</head>
<body>
<table border="2">
<tr>
<th>EMPNO  </th>
<th>ENAME</th>
<th>JOB</th>
<th>MGR</th>
<th>HIREDATE</th>
<th>SAL</th>
<th>COMM</th>
<th>DEPTNO</th>
</tr>

<%
	while (rs.next()){%>
<tr>
	<td><%=rs.getInt(1) %></td>
	<td><%=rs.getString(2) %></td>
	<td><%=rs.getString(3) %></td>
	<td><%=rs.getInt(4) %></td>
	<td><%=rs.getDate(5) %></td>
	<td><%=rs.getDouble(6) %></td>
	<td><%=rs.getDouble(7) %></td>
	<td><%=rs.getInt(8) %></td>
	
</tr>			
	<% }%>

</table>
</body>
</html>
<% 	//4. �پ� ������ �ݵ�� �ݾ��ش�
 	if (rs != null) rs.close();
 	if (pstmt != null) pstmt.close();
 	if (con != null) con.close();
 	request.setAttribute("emp_list",rs);
 	
 	%>