<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<% 
//사용자에게 전달받은 요청을 해석할때 사용할 charset을 설정
	request.setCharacterEncoding("EUC-KR");
// request의 요청을 해석하는ㄴ 방식은 수정해도 GET방식요청은 여전히 한글이 깨진다.
//GET 방식은 주소값(URI)에 실려서 도착하게 되는
//URI의 인코딩 방식은 Apache/Tomcat에서 결정
// Apache/Tomcat 기본값==> UTF-8

// Apache/Tomcat의 Connector설정에 URIEncoding="EUC-KR" 추가
//위치==>  Servers=> sever.xml    <Connector connectionTimeout="20000" port="8080" protocol="HTTP/1.1" redirectPort="8443" URIEncoding="EUC-KR"/>

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>한글 안나올때 설정방법</title>
</head>
<body>
	TEST : ${param.test }<br>
</body>
</html>