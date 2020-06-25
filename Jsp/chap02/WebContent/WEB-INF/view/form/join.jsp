<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%/* 
    private int id;		//회원 번호
	private String user_id;
	private String user_pwd;
	private String name;
	private Date joinDate;
	private Date birthday;
	private boolean validate; //인증여부
	private boolean marketing; //광고수신여부 */
    	%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>회원가입 폼</title>
</head>
<body>
<!-- /chap02/mvc/join 으로 GET방식 요청을 보내면 이 페이지로 도착하도록 만들어 보시오 -->
	<h1>회원가입 페이지</h1>
<form action="/chap02/mvc/join" method="POST">
<table>
<tr>
	<th>ID</th>
	<td><input name="user_id"></td>
</tr>
<tr>
	<th>PWD</th>
	<td><input name="user_pwd"></td>
</tr>
<tr>
	<th>name</th>
	<td><input name="name"></td>
</tr>
<tr>
	<th>Date</th>
	<td><input type="date" name="birthday"></td>
</tr>
<tr>
	<th>마켓팅동의</th>
	<td><input type="checkbox" name="marketing"></td>
</tr>
<tr>
	<td colspan="2"><button type="submit">회원가입</td>
	
	
</tr>	
</table>
</form>
</body>
</html>