<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<% 	
	String w_color =request.getParameter("word-color");
	String bg_color =request.getParameter("bg-color");
	
	request.setAttribute("w_color",w_color);
	request.setAttribute("bg_color",bg_color);

	%>
	<jsp:forward page="view/color.jsp"/>