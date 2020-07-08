<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
//로그아웃 버튼을 누르면 login이라는 이름의 쿠키를 삭제한 후 리다이렉트
	for (Cookie cookie: request.getCookies()){
		if(cookie.getName().equals("login")){
			cookie.setMaxAge(0);
			cookie.setPath("/");
			response.addCookie(cookie);
		}
	}
	response.sendRedirect("../login.jsp");
%>