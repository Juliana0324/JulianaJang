<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>search.jsp</title>
</head>
<body>
	<h1>학번 찾기</h1>
	<%--
	- /selectOne 요청을 통해 해당 학번을 가진 학생의 성적정보를
	  조회하여 search-result.jsp에서 해당 정보를 화면에 출력하세요.
 --%>
 
	<form action="/score/selectOne">
		<p>
			# 찾으실 학번: <input type="text" name="stuNum"> 
			<input type="submit" value="찾기">
		</p>
	</form>
	
	<p style="color:red">${msg}</p>
</body>
</html>