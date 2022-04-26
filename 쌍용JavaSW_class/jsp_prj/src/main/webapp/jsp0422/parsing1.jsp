<%@page import="java.util.Random"%>
<%@page import="org.json.simple.JSONObject"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
JSONObject jsonObj =new JSONObject();
jsonObj.put("name", "강산");
jsonObj.put("age", 20);
jsonObj.put("flag", new Random().nextBoolean());

//out.print(jsonObj.toJSONString()+")))"); => 200 parserError
out.print(jsonObj.toJSONString());
%>