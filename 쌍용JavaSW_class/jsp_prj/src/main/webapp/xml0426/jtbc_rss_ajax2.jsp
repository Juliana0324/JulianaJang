<%@page import="org.json.simple.JSONArray"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="java.util.List"%>
<%@page import="org.jdom2.Element"%>
<%@page import="java.net.URL"%>
<%@page import="org.jdom2.Document"%>
<%@page import="org.jdom2.input.SAXBuilder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
// https://fs.jtbc.joins.com/RSS/
String url = request.getParameter("rss");
String path="https://fs.jtbc.joins.com/RSS/";

SAXBuilder sb= new SAXBuilder();
Document doc= sb.build(new URL(path+url));

Element rootNode =doc.getRootElement();

Element channelNode=rootNode.getChild("channel");

List<Element> itemNodes = channelNode.getChildren("item");

JSONObject jsonObj = new JSONObject();
JSONObject jsonTemp = null;
JSONArray ja = new JSONArray();

Element itemNode=null;
Element titleNode=null;
Element linkNode=null;
Element descNode=null;
Element pubDateNode=null;

String title="", link="", desc="", pubDate="";
for(int i=0; i<itemNodes.size(); i++){
	itemNode= itemNodes.get(i); //리스트 i번째 방에 저장된 item노드를 꺼내와서 Element 저장
	titleNode=itemNode.getChild("title");	
	linkNode=itemNode.getChild("link");	
	descNode=itemNode.getChild("description");	
	pubDateNode=itemNode.getChild("pubDate");	
	
	jsonTemp = new JSONObject();
	jsonTemp.put("title",titleNode.getText() );
	jsonTemp.put("link",linkNode.getText() );
	jsonTemp.put("desc",descNode.getText() );
	jsonTemp.put("pubDate",pubDateNode.getText() );
	
}
%>