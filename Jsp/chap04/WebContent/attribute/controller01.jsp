<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	
	//JSP�������� HTML�� JAVA������ ���ÿ� ó�� ����������
	// �ΰ����� ȥ���ϸ� �ʹ� �ڵ尡 ������������ ũ�� �κκ����� �����Ͽ� ���


	//1.Ŭ���̾�Ʈ�� ��û�� �޾� ���� ������(ó��, ����Ͻ� ����)
	String w_color=request.getParameter("word-color");
	String bg_color=request.getParameter("bg-color");
	
	//���� �Ѱܹ��� ���� ���� �������� ó���� �̰��� ����
	// ex:��û���� ����� ���̵�/��� ��  ������ ������ �ִ� ���̵�/��й�ȣ ����
	// ex:��û���� ����� �˻��� �ش�˻���� ��ġ�ϴ� ������ �˻�..
	
	
	//---------------------------------
%>


<!--  2. ���� Ȱ���� ������ ���� (ȭ�� ó��) -->
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>controller01.jsp</title>

<style>
body{
	background-color: <%= bg_color%>;
	color: <%= w_color%>;
}
</style>

</head>
<body>
	<h1>������������ ó���� �� ��� ������ controller01</h1>
	<%-- 
		<%= %> : �� ����ڿ��� ����ϴ� ���� �ƴ϶� ���� ������ HTML���ڿ��� �߰��ϴ� ���̴�
	 --%>
	���޹��� �۾� ��: <%=w_color %>
	���޹��� ��� ��: <%=bg_color %>

</body>
</html>