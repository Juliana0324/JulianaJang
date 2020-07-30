<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="lab.web.member.MemberVO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원</title>
</head>
<body>
<%MemberVO mem=(MemberVO)request.getAttribute("mem"); %>
<h2>회원 페이지</h2>
<table border=1>
<tr><td>아이디</td><td><%=mem.getUserId() %></td></tr>
<tr><td>이름</td><td><%=mem.getName() %></td></tr>
<tr><td>비밀번호</td><td><%=mem.getPassword()%></td></tr>
<tr><td>이메일</td><td><%=mem.getEmail() %></td></tr>
<tr><td>주소</td><td><%=mem.getAddress() %></td></tr>
</table>
</body>
</html>