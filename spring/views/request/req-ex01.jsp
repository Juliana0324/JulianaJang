<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <h1>request컨트롤러를 이용한 요청 처리방법</h1>
 <p>컨트롤러 테스트 중입니다</p>
 
 <form action="/web/request/basic01">
 	<p>
 		<input type="submit" value="Get요청!">
 	</p>
 </form>
 
 
  <form action="/web/request/basic01" method="post">
 	<p>
 		<input type="submit" value="post요청!">
 	</p>
 </form>
 
 
 
</body>
</html>