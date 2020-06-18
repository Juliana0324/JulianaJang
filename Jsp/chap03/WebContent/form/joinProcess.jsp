<%@ page import ="java.util.Map" %>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<% 
	//form 테그로 전송한 데이터를 이곳에서 받는다
	//input 테그의 name설정한 값이 key가 된다
	
	//String name= request.getParameter("m_name");
	//String age= request.getParameter("m_age");
	//String email= request.getParameter("m_email");
	
	//checkbox로 여러개 전송되는 데이턴 getParameterValues()를 이용
	String [] hobbies =request.getParameterValues("hobbies");

	//request.getParameterMap() 전송된 모든 파라미터를 MAP타입으로 가져온다
	Map <String, String[]> paraMap = request.getParameterMap();
	%>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>joinProcess.jsp</title>
</head>
<body>
	<h1>join.html로부터 전송된 파라미터들</h1>


<%
if (hobbies != null){
	for(int i=0; i<hobbies.length;i++){
		out.print(hobbies[i]+"<br>");
	}
	}
	else{
		out.print("취미가 전송되지 않았습니다.");
	}


if(paraMap.get("gender") != null){
String msg="";
switch(paraMap.get("gender")[0]){
case "male":
	msg="요청을 보낸 사용자는 남자를 체크했습니다.";
	break;
case "female":
	msg="요청을 보낸 사용자는 여자를 체크했습니다.";
	break;
case "other":
	msg="요청을 보낸 사용자는 other를 체크했습니다.";
	break;
default:
	msg="성별을 체크하지 않았습니다.";
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