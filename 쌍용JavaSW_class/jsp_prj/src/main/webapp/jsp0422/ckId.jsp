<%@page import="org.json.simple.JSONArray"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="day0422.TestMemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<%

//입력된 아이디 받아 DB에 결과조회

//DB에서 결과조회
String id= request.getParameter("id");
 
TestMemberDAO tmd= TestMemberDAO.getInstance();
boolean flag = tmd.selectMember(id);

JSONObject jsonObj=new JSONObject();
jsonObj.put("flag", flag);

out.print(jsonObj.toJSONString());

%>