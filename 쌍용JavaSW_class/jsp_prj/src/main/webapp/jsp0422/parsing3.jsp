<%@page import="org.json.simple.JSONObject"%>
<%@page import="kr.co.sist.util.cipher.DataDecrypt"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="day0419.UploadFileVO"%>
<%@page import="java.util.List"%>
<%@page import="day0419.FileUploadDAO"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="org.json.simple.JSONArray"%>
<%@page import="java.util.ArrayList"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"
    info="복합 JSON"
    %>
<%

FileUploadDAO fuDAO = FileUploadDAO.getInstance();
List<UploadFileVO> list = fuDAO.selectList();

JSONObject jsonObj= new JSONObject();
jsonObj.put("pubDate", new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date()));
jsonObj.put("dateFlag", !list.isEmpty());
jsonObj.put("dataSize", list.size());

JSONArray jsonArr= new JSONArray();
JSONObject jsonTemp = null;

DataDecrypt dd= new DataDecrypt("abcdefghijklmn1234");
for(UploadFileVO ufVO: list){
	jsonTemp=new JSONObject();
	jsonTemp.put("num", ufVO.getNum());
	jsonTemp.put("name", dd.decryption(ufVO.getName()));
	jsonTemp.put("file_system_name", ufVO.getFile_system_name());
	jsonTemp.put("ip_address", ufVO.getIp_address());
	jsonTemp.put("input_date", ufVO.getInput_date());
	
	jsonArr.add(jsonTemp);
}

jsonObj.put("resultData", jsonArr);

out.println(jsonObj);
%>