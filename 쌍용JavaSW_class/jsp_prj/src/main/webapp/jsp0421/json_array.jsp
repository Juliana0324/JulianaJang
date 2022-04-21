<%@page import="org.json.simple.JSONObject"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- JSON Simple.jar
Map을 사용하여 구현된 JsonObject 생성라이브러리 

사용법)
1. JSON Object:
JSONObject json=new JSONObject();

2. 값할당 (순서대로 들어가지 않음)
json.put("이름", "값")

3. Json문자열 갖기
-->

<%
	String name="권용현";
	String addr="서울시 강남구 역삼동";
	int age=25;
	boolean flag=false;
	
	//JSON OBJECT생성
	JSONObject jsonObj = new JSONObject();
	
	//값 할당
	jsonObj.put("name", name);
	jsonObj.put("addr", addr);
	jsonObj.put("age", age);
	jsonObj.put("flag", flag);
	jsonObj.put("flag", true); //같은 이름이 존재하면 덮어씀
	
	
%>

<%=jsonObj.toJSONString() %>
