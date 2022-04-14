<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    info="입력URL로 이동할페이지를 설정하고 이동하는 일"
    %>
    
    <%
    	request.setCharacterEncoding("UTF-8");
    	String serverName=request.getServerName();
    	String moveURI= "kor.jsp";
    	String lang="한국어"; //파라미터 생성-> 전송
    	if(!serverName.equals("localhost")){
    		moveURI="eng.jsp";
	    	lang="영어";
    	}

    %>
	<%-- <jsp:forward page="<%=moveURI %>" /> --%>
	<!-- WEB 파라미터 생성하여 만들기 사이에 html절대 넣지말기!-->
	<jsp:forward page="<%=moveURI %>">
		<%--<!-- 이것은 html주석이징 (error) -->--%>
		<jsp:param value="<%=lang %>" name="lang"/>
	</jsp:forward>

