<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%
	
	//JSP페이지는 HTML과 JAVA문법을 동시에 처리 가능하지만
	// 두가지를 혼용하면 너무 코드가 복잡해짐으로 크게 두부분으로 분할하여 사용


	//1.클라이언트의 요청을 받아 값을 꺼낸다(처리, 비즈니스 로직)
	String w_color=request.getParameter("word-color");
	String bg_color=request.getParameter("bg-color");
	
	//처리가 끝난후 forward할 페이지에 전달하고싶은 데이털 Attribute에 등록
	//Attribute 란: 몇가지 내장객체에 key:value 실어놓을 수 있는 형태로 것
	//Attribute 를 등록할 수 있는 객체(수명이 긴 순서대로 나열):
		//application > session > request> pageContext

	request.setAttribute("w_color", w_color);
	request.setAttribute("bg_color", bg_color);
	
	
	
	
	
	//보통 넘겨받은 값을 통해 여러가지 처리를 이곳에 수행
	// ex:요청으로 날라온 아이디/비번 와  서버가 가지고 있는 아이디/비밀번호 대조
	// ex:요청으로 날라온 검색어 해당검색어와 일치하는 내용을 검색..
	
	
	//---------------------------------
	/* 
	Java로 forward하기 
		-servlet에서 사용시
		RequestDispatcher dispatcher
	*/
	
	/* RequestDispatcher dispatcher = request.getRequestDispatcher("view/color.jsp");
	dispatcher.forward(request,respond); */
%>
<!-- view파일 만든 후 color.jsp 만들어 이쪽으로 연결 -->
<jsp:forward page="view/color.jsp"/>