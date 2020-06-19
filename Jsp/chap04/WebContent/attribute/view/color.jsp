<%@ page import="chap01.tuto.Apple"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<% 

	//controller02.jsp러 갔던 요청이 forward 를 통해 그대로 color.jsp에 도착
	//controller02에서 등록한 Attribute도 함께 도착
	
	//Attribute에 실려온 데이터를 꺼내는 방법
	//1. object.getArribute(Key)
	// -Attribute를 등록했던 key값으로 Value를 꺼낼수 있다
	// -Object 타입으로 꺼내짐으로 다운케스팅 필요
	// - 찾는 key가 없을때 null로 반환되므로 주의!
	
	//2. EL(Expression Language)을 이용한다
	// - JSP영역에서 ${AttName}으로 간편하게 사용
	// - Attribute에 등록했던 key값을 바로사용 가능해서 편함!
	// - 실제로는 key를 통해 꺼낸 Value객체의 toString()을 이용
	
	
	String w_color=(String)request.getAttribute("w_color");
	String bg_color=(String)request.getAttribute("bg_color");
	
	//request.setAttribute("apple",new chap01.tuto.Apple());
	request.setAttribute("apple",new Apple());

%>


<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>color.jsp</title>

<style>
body{
	background-color: <%= bg_color%>;
	color: <%= w_color%>;
}
</style>

</head>
<body>
	<h1>controller02로 도착한 color.jsp</h1>
	<%-- 
		<%= %> : 는 사용자에게 출력하는 것이 아니라 위가 응답할 HTML문자열에 추가하는 것이다
	 --%>
	전달받은 글씨 색: <%=w_color %><br>
	전달받은 배경 색: <%=bg_color %><br>

	<h2>EL로 출력해보기</h2>
	전달받은 글씨 색: ${w_color}<br>
	전달받은 배경 색: ${bg_color}<br>
	여기서 추가한 사과 : ${apple}<br>



</body>
</html>