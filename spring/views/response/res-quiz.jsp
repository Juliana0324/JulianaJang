<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>quiz.jsp</title>
</head>
<body>

	<%-- 1. 이페이지의 화면 처리를 할 수 있는 메서드를 생성하세요(res-quiz) 
		2. 아이디와 비밀번호를 사용자에게 입력할 수 있는 창
		3.kim123, pw: kkk1234 라면 res-quizsuccess.jsp로 이동해서 
		로그인성공
		안되면 실패
	--%>
	<form action="<c:url value='/response/res-login'/>" method="post">
		<fieldset>
			<legend>로그인</legend>
			<p>
				#	Id:<input type="text" name="userId" size="10"><br>
				#	PW:<input type="password" name="userPw" size="10"><br>
				<input type="submit" value="로그인">
			</p>
		</fieldset>
	
	</form>
	
</body>
</html>