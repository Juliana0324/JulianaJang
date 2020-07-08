<%@page import="chap07.jdbc.JdbcConnector, java.sql.Connection, chap07.dao.*,chap07.dto.*" %>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <jsp:useBean class="chap07.dto.Login" id="input"/>
    <jsp:setProperty name="input" property="*"/>
<%
	//do ���丮���� ���ϵ��� ó���ϰ� redirect �� ����
	Connection conn=JdbcConnector.getConnection();
	// ����ڰ� �Ķ���ͷ� ������ ���̵�� DB���� ������ ������
	Login answer = LoginDAO.read(conn, input.getUser_id());
	
	System.out.println("answer " + answer);
	System.out.println("input " + input);
	
	if(answer==null){
		//���̵� ��ȸ���� ����
		//out.print("<h3>���̵� ��ȸ���� ����</h3>");
		session.setAttribute("status","���̵� Ȥ�� ��й�ȣ�� �ùٸ��� �ʽ��ϴ�.");
	}else{
		//����� ����ڰ� �Ķ���ͷ� �������� ��й�ȣ�� ����
		if(answer.getUser_pass().equals(input.getUser_pass())){
			Cookie loginCookie= new Cookie("login",Integer.toString(answer.getUser_per()));
			loginCookie.setMaxAge(-1);
			loginCookie.setPath("/");
			
			response.addCookie(loginCookie);

//		out.print("<h3>���̵�� ����� ��ġ�Ͽ� �α��� ����</h3>");		
		} else {
		//�α��� ����
		//out.print("<h3>���̵�� ��ȸ�Ǿ����� ��й�ȣ Ʋ��</h3>");
		session.setAttribute("status","���̵� Ȥ�� ��й�ȣ�� �ùٸ��� �ʽ��ϴ�.");
		}
	}
	
	if(conn!=null) conn.close();
	response.sendRedirect("../login.jsp");
%>