<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	
	//JSP페이지는 HTML과 JAVA문법을 동시에 처리 가능하지만
	// 두가지를 혼용하면 너무 코드가 복잡해짐으로 크게 두부분으로 분할하여 사용


	//1.클라이언트의 요청을 받아 값을 꺼낸다(처리, 비즈니스 로직)
	String w_color=request.getParameter("word-color");
	String bg_color=request.getParameter("bg-color");
	
	//보통 넘겨받은 값을 통해 여러가지 처리를 이곳에 수행
	// ex:요청으로 날라온 아이디/비번 와  서버가 가지고 있는 아이디/비밀번호 대조
	// ex:요청으로 날라온 검색어 해당검색어와 일치하는 내용을 검색..
	
	
	//---------------------------------
%>


<!--  2. 값을 활용해 페이지 생성 (화면 처리) -->
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>controller01.jsp</title>

<style>
body{
	background-color: <%= bg_color%>;
	color: <%= w_color%>;
}
</style>

</head>
<body>
	<h1>한페이지에서 처리와 뷰 모두 생성한 controller01</h1>
	<%-- 
		<%= %> : 는 사용자에게 출력하는 것이 아니라 위가 응답할 HTML문자열에 추가하는 것이다
	 --%>
	전달받은 글씨 색: <%=w_color %>
	전달받은 배경 색: <%=bg_color %>

</body>
</html>