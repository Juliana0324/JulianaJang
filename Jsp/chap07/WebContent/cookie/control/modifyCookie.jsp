<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<% 
	Cookie[] cookies = request.getCookies();
	if(cookies != null && cookies.length > 0){
		for(Cookie cookie : cookies){
			String name= cookie.getName();
			String value= cookie.getValue();
			if(name.equals("userAge")){
				//Cookie ������: ���� �̸�/����� ��Ű�� �ٽõ��(�����)
				Cookie modi=new Cookie("userAge","25");
				modi.setMaxAge(-1);
				//modi.setPath("/chap07/cookie");
				modi.setPath("/chap07");	
				//Path�� �޶����� Ȥ�� �߸� �����ϸ� �Ȱ��� �̸��� ��Ű�� �����ɼ� ����
				response.addCookie(modi);
				break;				
			}
		}
	}
	response.sendRedirect("../viewCookie.jsp");
%>