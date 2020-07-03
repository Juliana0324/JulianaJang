<%@ page import="java.sql.*" %>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	//jdbc : DB와의 연결을 위해 JAVA가 제공하는 API
	// 어떤 데이터베이스더라도 JAVA와의 연동을 위해서는 jdbc의 형태에 맞춰 API를 제공해야한다
	// 덕분에 자바 프로그래머들은 DB종류와 상관없이 일관된 코드를 작성할  수 있다

	// 가장 기본적인 JDBC의 사용법
	// 1. 클래스 로드
	// 	- 사용할 DB가 제공하는 JDBC드라이버를 불러온다
	//  - Class.forName("JDBC드라이버 클래스 경로");
	
	Class.forName("oracle.jdbc.driver.OracleDriver");
	// 2. DriverManager 클래스를 통해 DB와의 연결을 생성
 	String url="jdbc:oracle:thin:@localhost:1521:XE";
 	String user ="scott";
 	String pass="TIGER";
	
 	Connection con = DriverManager.getConnection(url,user,pass);
 	
 	//3. 받아온 연결을 통해 DB에 원하는 쿼리를 전달
 	// prepareStatement로 원하는 쿼리문을 준비
 	// execute문을 통해 쿼리문을 db에 전송
 	// - select문이라면 결과를 set타입으로 반환받는다
 	// - Insert, UPDATE, DELETE라면 바뀐 행의 개수를 int 로 반환한다
 	PreparedStatement pstmt = con.prepareStatement("SELECT * FROM EMP");
 	ResultSet rs=pstmt.executeQuery();
 	//request.setAttribute("emp_list",rs);
 	

 	
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>DB연결</title>
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
<% 	//4. 다쓴 연결은 반드시 닫아준다
 	if (rs != null) rs.close();
 	if (pstmt != null) pstmt.close();
 	if (con != null) con.close();
 	request.setAttribute("emp_list",rs);
 	
 	%>