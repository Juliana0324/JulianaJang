<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>CookieIndex</title>
</head>
<body>
<h3>쿠키란 무엇인가?</h3>

<p>
	HTTP는 사용자가 서버에 요청을 보내고 연결을 유지하지 않는 프로토콜이다.<br>
	이러한 특성을 상태가 유지되지 않는다 하여 stateless라고 부른다.<br>
	요청은 계속해서 유지되지 않기 때문에 유지되어야하는 정보를 저장하기에는 부족하다.<br>
</p>
<p>
	쿠키는 유지되어야하는 정보를 key-Value형태로 클라이언트의 웹브라우저에 저장한다.<br>
	서버에서 쿠키를 생성하여 클라이언트에게 보낼 응답에 실어서 보내면, <br>
	브라우저가 응답을 해석하여 브라우저에 쿠키를 등록한다<br>
</p>
<a href="./control/makeCookie.jsp"> 쿠키 생성하기</a><br>
<a href="./control/modifyCookie.jsp"> 쿠키 수정하기</a><br>
<a href="./control/deleteCookie.jsp"> 쿠키 삭제하기</a><br>

</body>
</html>