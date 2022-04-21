<%@page import="java.util.ArrayList"%>
<%@page import="day0406.TestVO"%>
<%@page import="java.util.List"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="org.json.simple.JSONArray"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
//List생성
List<TestVO> list = new ArrayList<TestVO>();
list.add(new TestVO("권용현", "서울시 강남구 역삼동", 24));
list.add(new TestVO("서울시", "서울시 강서구 발산동", 23));
list.add(new TestVO("강현모", "서울시 구로구 도봉동", 25));
list.add(new TestVO("서지숙", "서울시 동대문구 동대문동", 22));

//위의 리스트를 사용하여JSONArray생성
JSONArray ja= new JSONArray();

JSONObject listobj=null;
for(TestVO tv:list){
	listobj=new JSONObject();
	listobj.put("name", tv.getName());
	listobj.put("addr", tv.getAddr());
	listobj.put("age", tv.getAge());
	ja.add(listobj);
}
%>

<%=ja.toJSONString() %>
