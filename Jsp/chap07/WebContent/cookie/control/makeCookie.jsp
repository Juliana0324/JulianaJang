<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	Cookie cookie01 = new Cookie("userName","홍길동");
	Cookie cookie02 = new Cookie("userAge","20");
	Cookie cookie03 = new Cookie("noMoreToday","True");
	
	cookie01.setPath("/chap07/cookie");
	cookie02.setPath("/chap07/cookie");
	cookie03.setPath("/");
	
	//쿠키의 수명을 설정하면 쿠키의 만료시간을 결정할 수 있다.
	cookie01.setMaxAge(5); //쿠키수명 5초
	cookie02.setMaxAge(-1); //쿠키수명 -1(기본값): 브라우저 종료시 만료된다
	cookie03.setMaxAge(60 * 60 + 24);	//쿠키수명 하루 
	
	response.setCharacterEncoding("EUC-KR");
	
	response.addCookie(cookie01);
	response.addCookie(cookie02);
	response.addCookie(cookie03);
		
	response.sendRedirect("../viewCookie.jsp");
	//response.sendRedirect("../cookieIndex.jsp");

%>