<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="lab.web.member.MemberVO" import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입 페이지</title>
</head>
<body>
<%MemberVO mem=(MemberVO)request.getAttribute("mem"); %>
<h1>회원 가입</h1>
<form action="/JDBC/Member.do" method=post>
<input type=hidden name=action value=<%=request.getAttribute("action") %>>
<table border=1>
<tr>
	<td>회원 아이디</td>
	<td><input type=text name=userId ></td>
</tr>
<tr>
	<td>이름</td>
	<td><input type=text name=name ></td>
</tr>
<tr>
	<td>비밀번호</td>
	<td><input type=password name=password ></td>
</tr>
<tr>
	<td>이메일</td>
	<td><input type=text name=email ></td>
</tr>
<tr>
	<td>주소</td>
	<td><input type=text name=address></td>
</tr>
</table>
<input type=submit value=저장 value=<%=request.getAttribute("message") %>>
<input type=reset value=취소>
</form>
</body>
</html>