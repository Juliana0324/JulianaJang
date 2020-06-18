<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<% 	// 클라이언트가 요청하면 viewPage에 알맞은 경로를 설정한다
	String pageNum=request.getParameter("pageNum");
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
	
	//redirect는 사용자에게HTML코드를 응답하는 대신
	//다른페이지로 재 연결하라는 명령을 응답
	
	//sendRedirect:사용자에게 "이경로로 다시 요청해라"라고 응답하는것.
	
	//따라서 control2.jsp로 도착한 request객체와
	//선택한 viewPage로 이동했을때의 request 객체가 다르다
	
	// 상대경로인 경우 현재 연결했던 URL기준으로 찾아감
	//기존: http://localhost:8080/chap01/forward/control.jsp
	//없을때에 : http://localhost:8080/chap01/forward/+viewPage
	
	// redirect방식 : 시스템에 변화가 생기는 요청(로그인,회원가입,글쓰기)
	// forward방식 : 시스템에 변화가 생기지 않는 요청(리스트 보기,검색)
	response.sendRedirect(viewPage);
%>