<%@ page import ="java.util.Map" %>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<% 
	//form �ױ׷� ������ �����͸� �̰����� �޴´�
	//input �ױ��� name������ ���� key�� �ȴ�
	//String name= request.getParameter("m_name");
	//String age= request.getParameter("m_age");
	//String email= request.getParameter("m_email");
	
	//request.getParameterMap() ���۵� ��� �Ķ���͸� MAPŸ������ �����´�
	Map <String, String[]> paraMap = request.getParameterMap();
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>joinProcess.jsp</title>
</head>
<body>
	<h1>join.html�κ��� ���۵� �Ķ���͵�</h1>


<%
for (String key: paraMap.keySet()){
		String[] values = paraMap.get(key);
		out.print(key+ " : ");
		for(String value: values){
			out.print(value);
		}
		out.print("<br>");		
} %>	



</body>
</html>