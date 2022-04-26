<%@page import="org.json.simple.JSONObject"%>
<%@page import="org.json.simple.JSONArray"%>
<%@page import="java.util.ArrayList"%>
<%@page import="day0406.TestVO"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>

<%
JSONArray jsonArr=new JSONArray();

JSONObject jsonObj=new JSONObject();
jsonObj.put("name","강산");
jsonObj.put("age",20);

JSONObject jsonObj2=new JSONObject();
jsonObj2.put("name","강현모");
jsonObj2.put("age",23);

JSONObject jsonObj3=new JSONObject();
jsonObj3.put("name","박설빈");
jsonObj3.put("age",21);

jsonArr.add(jsonObj);
jsonArr.add(jsonObj2);
jsonArr.add(jsonObj3);

out.print(jsonArr.toJSONString());
%>