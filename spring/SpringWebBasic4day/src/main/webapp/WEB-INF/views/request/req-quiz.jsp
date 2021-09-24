<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>


<%--
	# 문제
	1. RequestController에 현재 파일을 열어주는 메서드 생성
	 - url: /request/quiz : GET
	 - views: /request/req-quiz.jsp
	 - method-name: quiz()
	2. RequestController에 전송된 아이디, 비밀번호 파라미터를
	  받아 로그인을 처리하는 메서드 생성
	 - url: /request/quiz : POST
	 - views: 
	 	성공시: /request/login-success.jsp
	 	실패시: /request/login-fail.jsp
	 - method-name: quiz()
	3. 로그인 성공조건: 
	 - id값이 : abc1234 , pw: xxx4321
 --%>


	<form action="/quiz" method="post">
		<fieldset>
			<p>
				-ID : <input type="text" name="userId" size="10">
				-PW : <input type="password" name="userPw" size="10">
				<input type="submit" value="로그인">
			</p>
			
		</fieldset>
	</form>

</body>
</html>