<%@page import="org.jdom2.output.Format"%>
<%@page import="org.jdom2.output.XMLOutputter"%>
<%@page import="org.jdom2.Element"%>
<%@page import="org.jdom2.Document"%>
<%@ page language="java" contentType="text/xml; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"
    %>

<%
String[] rssTitle={"속보","정치","경제","사회","국제","문화","연예","스포츠"
,"풀영상","뉴스랭킹","뉴스룸","아침&amp;","썰전 라이브","정치부회의"};

Document doc=new Document();
Element rootNode=new Element("rss_title");

Element titleNode=null;
for(String title:rssTitle){
	titleNode=new Element("title");
	titleNode.setText(title);
	rootNode.addContent(titleNode);
}
doc.addContent(rootNode);

new XMLOutputter(Format.getPrettyFormat()).output(doc, out);
%>