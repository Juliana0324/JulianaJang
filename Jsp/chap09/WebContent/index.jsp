<%@ page import ="java.sql.*" %>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	//Ŀ�ؼ� Ǯ ����̹� ���� �Ŀ��� Ŀ�ؼ� Ǯ�� uri�� Ŀ�ؼ��� ��û�Ѵ�
	Connection conn = DriverManager.getConnection("jdbc:apache:commons:dbcp:mydbcp");
	//Ŀ�ؼ� Ǯ���� �޾ƿ� conn�� close()�� DB���� ������ �������� ���� �ƴ϶� connectionPool�� ��ȯ�ȴ�
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