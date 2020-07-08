<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<% 
	//noMoreToday 삭제해보기
	Cookie[] cookies = request.getCookies();
	if(cookies != null && cookies.length > 0){
		for(Cookie cookie : cookies){
			String name= cookie.getName();
			String value= cookie.getValue();
			if(name.equals("noMoreToday")){
				//Cookie 삭제시: 같은 이름/경로의 쿠키의 만료시간을 0으로 변경
				Cookie modi=new Cookie("noMoreToday","False");
				modi.setMaxAge(0);
				modi.setPath("/");
				response.addCookie(modi);
				break;				
			}
		}
	}
	response.sendRedirect("../viewCookie.jsp");
%>