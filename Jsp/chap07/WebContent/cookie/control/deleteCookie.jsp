<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<% 
	//noMoreToday �����غ���
	Cookie[] cookies = request.getCookies();
	if(cookies != null && cookies.length > 0){
		for(Cookie cookie : cookies){
			String name= cookie.getName();
			String value= cookie.getValue();
			if(name.equals("noMoreToday")){
				//Cookie ������: ���� �̸�/����� ��Ű�� ����ð��� 0���� ����
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