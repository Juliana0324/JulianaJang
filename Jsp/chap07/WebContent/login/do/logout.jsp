<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
//�α׾ƿ� ��ư�� ������ login�̶�� �̸��� ��Ű�� ������ �� �����̷�Ʈ
	for (Cookie cookie: request.getCookies()){
		if(cookie.getName().equals("login")){
			cookie.setMaxAge(0);
			cookie.setPath("/");
			response.addCookie(cookie);
		}
	}
	response.sendRedirect("../login.jsp");
%>