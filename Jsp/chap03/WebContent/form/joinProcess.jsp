<%@ page import ="java.util.Map" %>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<% 
	//form �ױ׷� ������ �����͸� �̰����� �޴´�
	//input �ױ��� name������ ���� key�� �ȴ�
	
	//String name= request.getParameter("m_name");
	//String age= request.getParameter("m_age");
	//String email= request.getParameter("m_email");
	
	//checkbox�� ������ ���۵Ǵ� ������ getParameterValues()�� �̿�
	String [] hobbies =request.getParameterValues("hobbies");

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
if (hobbies != null){
	for(int i=0; i<hobbies.length;i++){
		out.print(hobbies[i]+"<br>");
	}
	}
	else{
		out.print("��̰� ���۵��� �ʾҽ��ϴ�.");
	}


if(paraMap.get("gender") != null){
String msg="";
switch(paraMap.get("gender")[0]){
case "male":
	msg="��û�� ���� ����ڴ� ���ڸ� üũ�߽��ϴ�.";
	break;
case "female":
	msg="��û�� ���� ����ڴ� ���ڸ� üũ�߽��ϴ�.";
	break;
case "other":
	msg="��û�� ���� ����ڴ� other�� üũ�߽��ϴ�.";
	break;
default:
	msg="������ üũ���� �ʾҽ��ϴ�.";
	break;
}
out.print("<h3>"+msg+"</h3>");
}

for (String key: paraMap.keySet()){
		String[] values = paraMap.get(key);
		out.print(key+ " : ");
		for(String value: values){
			out.print(value+" , ");
		}
		out.print("<br>");		
} %>	



</body>
</html>