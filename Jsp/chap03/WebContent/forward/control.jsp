<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	// 클라이언트가 요청하면 viewPage에 알맞은 경로를 설정한다
	String pageNum=request.getParameter("pageNum");
	//select.jsp name에서 pageNum설정해놨기 때문에

	String viewPage = null;
	int nextPage=404;
	try {
		nextPage=Integer.parseInt(pageNum);
	}catch(NumberFormatException e){}

	switch(nextPage){
	case 1:
		viewPage="view/1.jsp";
		break;
	case 2:
		viewPage="view/2.jsp";
		break;
	case 3:
		viewPage="view/3.jsp";
		break;
	default :
		viewPage="view/404.jsp";
		break;
	}
%>

<!-- 
	JSP: HTML문자열을 만들어 내는 프레임 워크
	forward사용시 아직 진행중이라는 의미
	forward 방식으로 응답을 생성: 
		1.현재 페이지로 도착한 요청을 그대로 들고 다른페이지로 이동
		2.이동한 페이지에서 생성한 HTML문자열을 사용자에게 응답(response).
 -->
<jsp:forward page="<%=viewPage %>"/>
<% System.out.println("after forward"); %>
<!-- 
	forward 끝난후 JSP페이지가 끝나면 HTML문자열을 응답: -->