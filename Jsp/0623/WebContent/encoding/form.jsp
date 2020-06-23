<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!-- 
	contentType의 인코딩 설정
		- JSP 페이지에서 생성할 HTML응답의 캐릭터 셋 설정
		- response보낼 때의  character set
		
	pageEncoding의 인코딩 설정
		- JSP코드가 JAVA코드로 변환될때 사용할 charset설정
		- JAVA코드의 character set
 -->


<!DOCTYPE html>
<html>
<head>
<!-- html의 인코딩 설정
	- meta charset==>여기에 선언된 인코딩 방식으로 웹 브라우저가 문서를 해석 
	- 클라이언트의 웹브라우저에서 이 응답을 해석할때 사용할 인코딩 타입의 설정
	- response를 받은 후의  character set
	
 -->
<meta charset="EUC-KR">
<title>form</title>
</head>
<body>
<h3>GET방식</h3>
	<form action="control.jsp" method="GET">
		<input name="test" value="홍길동"><input type="submit">
	</form>
	
<h3>POST방식</h3>
	<form action="control.jsp" method="POST">
		<input name="test" value="홍길동"><input type="submit">
	</form>

</body>
</html>