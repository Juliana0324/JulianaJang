<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="http://211.63.89.147/jsp_prj/common/css/main_20220321.css"/>
<!-- bootstrap CDN -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>

<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script type="text/javascript">
$(function() {
	
});//ready
</script>
<style type="text/css">

</style>
</head>
<body>
<div>
<ul>

<li>내장객체: <%=request %></li> <!-- HTt[Servlet 구현 객체명 -->
<li>요청 URL: <%=request.getRequestURI() %></li>
<li>요청 프로토콜: <%=request.getProtocol() %></li>
<li>요청 서버명: <%=request.getServerName() %> </li>
<li>요청 서버포트: <%=request.getServerPort() %></li>
<li>ContextPath: <%=request.getContextPath() %></li>
<li>ServletPath: <%=request.getServletPath() %></li>
<li>QueryString: <%=request.getQueryString() %></li><!-- QueryString이 존재하지 않으면 null -->
<li>WebParameter: <%=request.getParameter("name") %></li>
<li>WebParameter: <%=request.getParameter("age") %></li>
<!-- 접속자 정보 얻기 -->
<li>&nbsp;---접속자 정보얻기---&nbsp;</li>
<li>접속자 ip: <%=request.getRemoteAddr() %></li>
<li>접속자 port:<%=request.getRemotePort() %></li>
<li>접속자 ip:<%=request.getRemoteHost() %></li>
</ul>
<div>
Header정보<br/>
<ul>
<%
	Enumeration<String> en = request.getHeaderNames();
	String headerName="";
	String headerValue="";
	
	while(en.hasMoreElements()){
		headerName=en.nextElement();
		headerValue=request.getHeader(headerName);
%>
<li><strong><%=headerName %></strong>: <%=headerValue %></li>
<%
	}
	 %>
	 </ul>
</div>
</div>
<a href="useRequest.jsp?name=test&age=20">요청</a>

<form action="useRequest.jsp" method="get">
<input type="hidden" id="getname" name="name" value="getName"/>
<input type="hidden" id="getage" name="age" value="20"/>

<input type="submit" value="get" class="btn btn-outline-primary btn-lg" />Get전송
</form>

<form action="useRequest.jsp" method="post">
<input type="hidden" id="postname" name="name" value="postName"/>
<input type="hidden" id="postage" name="age" value="30"/>

<input type="submit" value="post" class="btn btn-primary" />POST전송
</form>

</body>
</html>