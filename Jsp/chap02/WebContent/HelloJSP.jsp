<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="chap01.util.Shortcuts" %>
    <%-- �ּ� --%>
    <%-- <% %>: ��� �ڹ� �ڵ� ��밡�� ���� --%>
    <%-- <%! %>: �Լ� ���� ��� --%>
    <%-- <%= %>: ������ ��� ���� HTML�ڵ忡 ��� --%>
    <%-- <%@ %>: ������ ����, jsp������ ����--%>
    <%! 
    private int add(int A,int B){
    	return A+B;
    }
    %>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Hello JSP</title>
<%--	Css (StyleSHeet)������
	-������ �������� ���--%>
	<style>
	#time {
	font-size: 1.5em;
	}
	#bg-img{
	position:fixed;
	z-index:-1;
	top:0;
	left:0;
	width:100%;
	height:100%;}

	</style>
</head>
<body>
	<h1 style="color:yellowgreen;">Hello JSP PAGE!!!</h1>
	<p>
	Servlet: �ڹ� �ڵ� ����ϱ� ����
	JSP: HTML�ڵ� ����ϱ� ����
	</p>
	<ol>
 
	<% for(int i=0; i<10;++i){%>
		<li style="color: skyblue">�ݺ��Ǵ� ���� <%=add(i,9999) %></li>
	<% }%>
	
	</ol>
	
	<div id="time"><%= Shortcuts.getCurrentTime("yyyy-MM-dd / hh:mm:ss") %></div>
	<img id="bg-img" src="https://mblogthumb-phinf.pstatic.net/20151215_146/rlatnals8712_1450141030738pC6eR_PNG/20151215_094901.png?type=w800">
	
	<% for (int i=0; i<10;i++){%>
		<div>div�� �־���� �������� �����</div>
	<% } %>
</body>
</html>