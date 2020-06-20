<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
   <%
   String w_color=request.getParameter("word_color");
   String bg_color=request.getParameter("bg_color");
   
   request.setAttribute("w_color", w_color);
   request.setAttribute("bg_color", bg_color);
   %>
<jsp:forward page="view/color1.jsp"/>