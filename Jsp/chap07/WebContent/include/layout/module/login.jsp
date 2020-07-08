<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import ="java.sql.*" %>
<% 
	Class.forName("oracle.jdbc.driver.OracleDriver");
	String url="jdbc:oracle:thin:@localhost:1521:XE";
 	String user ="scott";
 	String pass="TIGER";
 	
	Connection con=DriverManager.getConnection(url,user,pass);
 	PreparedStatement pstmt = con.prepareStatement("SELECT * FROM MY_LOGIN");
 	ResultSet rs=pstmt.executeQuery();
 	
 	%>
 	<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>MY_LOGIN연결</title>
<table border="1">
	<tr>
		<th>user_ID</th>
		<th>user_PASS</th>
		<th>user_PER</th>
	</tr>
</table>

<%
	while(rs.next()){%>	
		<th><%=rs.getString(1) %></th>
		<th><%=rs.getInt(2) %></th>
		<th><%=rs.getInt(3) %></th>
		
		
	}

%>

</head>
<body>
</body>
</html>