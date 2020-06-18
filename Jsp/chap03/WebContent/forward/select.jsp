<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h3>보고싶은 페이지를 선택하세요</h3>
	<form action="control.jsp" method="GET">
		<select name="pageNum">
			<option value="1" selected>페이지1</option>
			<option value="2">페이지2</option>
			<option value="3">페이지3</option>
		</select>
		<input type="submit" value="컨트롤러로 요청 전송 ">
	</form>
	
	<!-- redirect의 다른점 -->
	<h3>redirect</h3>
	<form action="control2.jsp" method="GET">
		<select name="pageNum">
			<option value="1" selected>페이지1</option>
			<option value="2">페이지2</option>
			<option value="3">페이지3</option>
		</select>
		<input type="submit" value="컨트롤러로 요청 전송 ">
	</form>
	<!-- a테그로 똑같은 요청 보내기 -->
<a href="./control.jsp?pageNum=1">1.jsp</a> <br>
<a href="./control.jsp?pageNum=2">2.jsp</a> <br>
<a href="./control.jsp?pageNum=3">3.jsp</a> <br>
<a href="./control.jsp?pageNum=404">404.jsp</a> <br>

	<h3>servlet=forward</h3>
	<form action="/chap01/forward" method="GET">
		<select name="pageNum">
			<option value="1" selected>페이지1</option>
			<option value="2">페이지2</option>
			<option value="3">페이지3</option>
		</select>
		<input type="submit" value="컨트롤러로 요청 전송 ">
	</form>
		<h3>redirect-servlet</h3>
	<form action="/chap01/redirect" method="GET">
		<select name="pageNum">
			<option value="1" selected>페이지1</option>
			<option value="2">페이지2</option>
			<option value="3">페이지3</option>
		</select>
		<input type="submit" value="컨트롤러로 요청 전송 ">
	</form>
</body>
</html>