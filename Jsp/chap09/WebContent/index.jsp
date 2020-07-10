<%@ page import ="java.sql.*" %>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	//커넥션 풀 드라이버 생성 후에는 커넥션 풀의 uri에 커넥션을 요청한다
	Connection conn = DriverManager.getConnection("jdbc:apache:commons:dbcp:mydbcp");
	//커넥션 풀에서 받아온 conn은 close()시 DB와의 연결이 끊어지는 것이 아니라 connectionPool에 반환된다
	PreparedStatement pstmt=conn.prepareStatement("SELECT * FROM my_login");
	ResultSet rs=pstmt.executeQuery();
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>DBCP TEST</title>
</head>
<body>
	<h3>DBCP TEST</h3>
	<% while (rs.next()) { %>
		<p><%=rs.getString(1) %>, <%=rs.getString(2) %>, <%= rs.getString(3)%></p>
	<% } %>
</body>
</html>
<%

	if(rs != null) rs.close();
	if(pstmt != null) pstmt.close();
	if(conn != null) conn.close();

%>