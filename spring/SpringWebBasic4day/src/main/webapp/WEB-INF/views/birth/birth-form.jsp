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
	1. 다음 생년월일을 받아서 콘솔에 출력하는 
	   메서드를 생성 (url: /birth : POST)
          조건) BirthVO 커맨드객체 사용, 
          콘솔에 전송된 값을 붙여서 출력합니다 ex)20180615
	2. birth-result.jsp 페이지에 
	"당신의 생일은 ~~~~년 ~~월 ~~일입니다." 을 출력하세요
--%>

	<form action="/birth" method="POST">
		<fieldset>
			<legend>생년월일 값</legend>
			<p>
				# Born Year : <input type="text" name="year" size="10"><br>
				# Born Month: <input type="text" name="month" size="10"><br>
				# Born day: <input type="text" name="day" size="10"><br>
				
				<input type="submit" value="생년월일은">
			</p>
		</fieldset>				
	</form>
</body>
</html>