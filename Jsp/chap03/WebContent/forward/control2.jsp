<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<% 	// Ŭ���̾�Ʈ�� ��û�ϸ� viewPage�� �˸��� ��θ� �����Ѵ�
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
	
	//redirect�� ����ڿ���HTML�ڵ带 �����ϴ� ���
	//�ٸ��������� �� �����϶�� ����� ����
	
	//sendRedirect:����ڿ��� "�̰�η� �ٽ� ��û�ض�"��� �����ϴ°�.
	
	//���� control2.jsp�� ������ request��ü��
	//������ viewPage�� �̵��������� request ��ü�� �ٸ���
	
	// ������� ��� ���� �����ߴ� URL�������� ã�ư�
	//����: http://localhost:8080/chap01/forward/control.jsp
	//�������� : http://localhost:8080/chap01/forward/+viewPage
	
	// redirect��� : �ý��ۿ� ��ȭ�� ����� ��û(�α���,ȸ������,�۾���)
	// forward��� : �ý��ۿ� ��ȭ�� ������ �ʴ� ��û(����Ʈ ����,�˻�)
	response.sendRedirect(viewPage);
%>