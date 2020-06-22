<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<% 
	//JSP에서 Attribute를 실어놓을수 있는 객체 4가지
	// 1. application 객체
	//  	-한 서버에 하나이며, 서버가 꺼질때 까지 값이 유지된다.
	// 2. session 객체
	//		- 한 브라우저(클라이언트) 당 하나이며, 세션이 만료 될때 까지 유지된다.
	//			로그인 유지해야할 때 사용 
	// 3. request 객체
	//		- 요청마다 생기는 객체. forward를 통한 전달까지 가능
	// 4. pageContext 객체
	//		- 하나의 JSP페이지를 벗어나면 수명이 다하는 내장객체
	
	application.setAttribute("id","app_id");
	session.setAttribute("id","session_id");
	request.setAttribute("id","req_id");
	pageContext.setAttribute("id","page_id");

%>


<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h3>EL로 ID를 출력: ${id }</h3>
	<p>
	EL을 통해 Attribute값을 사용할 시에 중복되는 key값이 있다면,<br>
	가장 좁은 범위의 값을 순서대로 사용 ==> page,request,session,application
	</p>
	<hr>
	<h3>EL의 literal</h3>
		<ul>
			<li> boolean type: ${true },${false }</li>
			<li> int type: ${123 },${456 }</li>
			<li> double type: ${1.234 },${45.6 }</li>
			<li> String type: ${"JAVA" },${'Python' }</li>
		</ul>
		<hr>
	<h3>EL의 연산자</h3>
		<ul>
			<li>
				산술연산자: +,-,/,*,%,mod
			</li>
			<li>
				비교연산자: ==,!=,&lt;,&gt;, &ge;,&le;,
					eq(equal),ne(not equal),lt(lesser than),gt(greater than),
					le(lesser or equal),ge(greater than equal)	
			</li>
			<li>
			${'a' eq 'a' },${'c' gt 'a' },${'z' lt 'a' }
			</li>
			<li>
				논리 연산자 : &&. ||. !,and, or, not
			</li>
			<li>
			${true or false },${true and true },${not true },${!treue }
			</li>
			<li>
				-Parameter체크시 좋음-<br>
				empty: null이거나 비어있는 문자라면 true
			</li>

		</ul>	
		<%
		//empty를 자바로 표현하기 번거롭다
		String str= "";
		out.print(str ==null || str =="");
		%>	
		
		<hr>
		<h3>EL로 JSP객체에 접근</h3>
		<p>가장 가까운 영여을 무시하고 원하는 영역의 Attribute 접근</p>
		pageScope: ${pageScope.id }<br>
		requestScope: ${requestScope.id }<br>
		sessionScope: ${sessionScope.id }<br>
		applicationScope: ${applicationScope.id }<br>
	
	<p>
		파라미터 값에 접근하기(클라이언트가 FORM으로 전송한 데이터)<br>
		잘 사용안함
	</p>
	파라미터 값 보기 : param.key ${param.age }<br>
	파라미터의 모든값 보기: paramValues ${paramValues }<br>
	
	<p>
		쿠키값에 접근하기
	</p>
	쿠키값 보기: ${cookie.JSESSIONID.name }=${cookie.JSESSIONID.value }
	
</body>
</html>