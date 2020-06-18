<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	// Ŭ���̾�Ʈ�� ��û�ϸ� viewPage�� �˸��� ��θ� �����Ѵ�
	String pageNum=request.getParameter("pageNum");
	//select.jsp name���� pageNum�����س��� ������

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
	JSP: HTML���ڿ��� ����� ���� ������ ��ũ
	forward���� ���� �������̶�� �ǹ�
	forward ������� ������ ����: 
		1.���� �������� ������ ��û�� �״�� ��� �ٸ��������� �̵�
		2.�̵��� ���������� ������ HTML���ڿ��� ����ڿ��� ����(response).
 -->
<jsp:forward page="<%=viewPage %>"/>
<% System.out.println("after forward"); %>
<!-- 
	forward ������ JSP�������� ������ HTML���ڿ��� ����: -->