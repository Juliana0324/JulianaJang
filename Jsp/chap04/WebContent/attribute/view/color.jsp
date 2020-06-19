<%@ page import="chap01.tuto.Apple"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<% 

	//controller02.jsp�� ���� ��û�� forward �� ���� �״�� color.jsp�� ����
	//controller02���� ����� Attribute�� �Բ� ����
	
	//Attribute�� �Ƿ��� �����͸� ������ ���
	//1. object.getArribute(Key)
	// -Attribute�� ����ߴ� key������ Value�� ������ �ִ�
	// -Object Ÿ������ ���������� �ٿ��ɽ��� �ʿ�
	// - ã�� key�� ������ null�� ��ȯ�ǹǷ� ����!
	
	//2. EL(Expression Language)�� �̿��Ѵ�
	// - JSP�������� ${AttName}���� �����ϰ� ���
	// - Attribute�� ����ߴ� key���� �ٷλ�� �����ؼ� ����!
	// - �����δ� key�� ���� ���� Value��ü�� toString()�� �̿�
	
	
	String w_color=(String)request.getAttribute("w_color");
	String bg_color=(String)request.getAttribute("bg_color");
	
	//request.setAttribute("apple",new chap01.tuto.Apple());
	request.setAttribute("apple",new Apple());

%>


<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>color.jsp</title>

<style>
body{
	background-color: <%= bg_color%>;
	color: <%= w_color%>;
}
</style>

</head>
<body>
	<h1>controller02�� ������ color.jsp</h1>
	<%-- 
		<%= %> : �� ����ڿ��� ����ϴ� ���� �ƴ϶� ���� ������ HTML���ڿ��� �߰��ϴ� ���̴�
	 --%>
	���޹��� �۾� ��: <%=w_color %><br>
	���޹��� ��� ��: <%=bg_color %><br>

	<h2>EL�� ����غ���</h2>
	���޹��� �۾� ��: ${w_color}<br>
	���޹��� ��� ��: ${bg_color}<br>
	���⼭ �߰��� ��� : ${apple}<br>



</body>
</html>