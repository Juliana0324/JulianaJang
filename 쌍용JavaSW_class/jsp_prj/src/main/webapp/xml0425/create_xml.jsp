<%@page import="org.jdom2.output.XMLOutputter"%>
<%@page import="day0418.empVO"%>
<%@page import="java.util.List"%>
<%@page import="day0418.empDAO"%>
<%@page import="org.jdom2.Document"%>
<%@page import="xml0425.CreateEMPXML"%>
<%@ page language="java" contentType="text/xml; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%
//XML생성 객체를 생성
	CreateEMPXML ceXML=new CreateEMPXML();
//db에서 조회한 결과를 얻어와
empDAO eDao=new empDAO();
List<empVO> list = eDao.selectAllEmp();

//XML생성객체에서 xml을 얻는다
Document doc= ceXML.createEmpXml(list);

//출력객체 생성
XMLOutputter xOut= new XMLOutputter();

//접속자 브라우저로 xml 객체 출력
xOut.output(doc, out); //JSPWriter의 내장객체인 out를 입력하므로 접속자의 브라우저로 출력

%>


