<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="chap01.util.Shortcuts" %>
    <%-- 주석 --%>
    <%-- <% %>: 모든 자바 코드 사용가능 영역 --%>
    <%-- <%! %>: 함수 선언 방법 --%>
    <%-- <%= %>: 변수에 담긴 값을 HTML코드에 출력 --%>
    <%-- <%@ %>: 페이지 설정, jsp문법을 따름--%>
    <%! 
    private int add(int A,int B){
    	return A+B;
    }
    %>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Hello JSP</title>
<%--	Css (StyleSHeet)영ㅇ역
	-페이지 디자인을 담당--%>
	<style>
	#time {
	font-size: 1.5em;
	}
	#bg-img{
	position:fixed;
	z-index:-1;
	top:0;
	left:0;
	width:100%;
	height:100%;}

	</style>
</head>
<body>
	<h1 style="color:yellowgreen;">Hello JSP PAGE!!!</h1>
	<p>
	Servlet: 자바 코드 사용하기 편함
	JSP: HTML코드 사용하기 편함
	</p>
	<ol>
 
	<% for(int i=0; i<10;++i){%>
		<li style="color: skyblue">반복되는 내용 <%=add(i,9999) %></li>
	<% }%>
	
	</ol>
	
	<div id="time"><%= Shortcuts.getCurrentTime("yyyy-MM-dd / hh:mm:ss") %></div>
	<img id="bg-img" src="https://mblogthumb-phinf.pstatic.net/20151215_146/rlatnals8712_1450141030738pC6eR_PNG/20151215_094901.png?type=w800">
	
	<% for (int i=0; i<10;i++){%>
		<div>div에 넣어놓은 쓰데없는 내용들</div>
	<% } %>
</body>
</html>