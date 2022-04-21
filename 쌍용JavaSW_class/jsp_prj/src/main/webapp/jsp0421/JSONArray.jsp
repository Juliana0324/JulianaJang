<%@page import="org.json.simple.JSONObject"%>
<%@page import="org.json.simple.JSONArray"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
//JSONArray생성
JSONArray ja = new JSONArray();

//JSONObject 생성
JSONObject jobj= new JSONObject();
jobj.put("name", "권용현");
jobj.put("age", 20);

JSONObject jobj2= new JSONObject();
jobj2.put("name", "전민정");
jobj2.put("age", 21);

JSONObject jobj3= new JSONObject();
jobj3.put("name", "강햔모");
jobj3.put("age", 21);

//JSONArray추가
ja.add(jobj);
ja.add(jobj2);
ja.add(jobj3);
%>

<%=ja.toJSONString()%>