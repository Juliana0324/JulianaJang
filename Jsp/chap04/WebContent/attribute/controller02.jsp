<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%
	
	//JSP�������� HTML�� JAVA������ ���ÿ� ó�� ����������
	// �ΰ����� ȥ���ϸ� �ʹ� �ڵ尡 ������������ ũ�� �κκ����� �����Ͽ� ���


	//1.Ŭ���̾�Ʈ�� ��û�� �޾� ���� ������(ó��, ����Ͻ� ����)
	String w_color=request.getParameter("word-color");
	String bg_color=request.getParameter("bg-color");
	
	//ó���� ������ forward�� �������� �����ϰ���� ������ Attribute�� ���
	//Attribute ��: ��� ���尴ü�� key:value �Ǿ���� �� �ִ� ���·� ��
	//Attribute �� ����� �� �ִ� ��ü(������ �� ������� ����):
		//application > session > request> pageContext

	request.setAttribute("w_color", w_color);
	request.setAttribute("bg_color", bg_color);
	
	
	
	
	
	//���� �Ѱܹ��� ���� ���� �������� ó���� �̰��� ����
	// ex:��û���� ����� ���̵�/��� ��  ������ ������ �ִ� ���̵�/��й�ȣ ����
	// ex:��û���� ����� �˻��� �ش�˻���� ��ġ�ϴ� ������ �˻�..
	
	
	//---------------------------------
	/* 
	Java�� forward�ϱ� 
		-servlet���� ����
		RequestDispatcher dispatcher
	*/
	
	/* RequestDispatcher dispatcher = request.getRequestDispatcher("view/color.jsp");
	dispatcher.forward(request,respond); */
%>
<!-- view���� ���� �� color.jsp ����� �������� ���� -->
<jsp:forward page="view/color.jsp"/>