<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<% 
	Cookie[] cookies = request.getCookies();
	if(cookies != null && cookies.length > 0){
		for(Cookie cookie : cookies){
			String name= cookie.getName();
			String value= cookie.getValue();
			if(name.equals("userAge")){
				//Cookie 수정시: 같은 이름/경로의 쿠키를 다시등록(덮어쓰기)
				Cookie modi=new Cookie("userAge","25");
				modi.setMaxAge(-1);
				//modi.setPath("/chap07/cookie");
				modi.setPath("/chap07");	
				//Path가 달라지면 혹은 잘못 설정하면 똑같은 이름의 쿠키가 생성될수 있음
				response.addCookie(modi);
				break;				
			}
		}
	}
	response.sendRedirect("../viewCookie.jsp");
%>