<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%/* 
    private int id;		//ȸ�� ��ȣ
	private String user_id;
	private String user_pwd;
	private String name;
	private Date joinDate;
	private Date birthday;
	private boolean validate; //��������
	private boolean marketing; //������ſ��� */
    	%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>ȸ������ ��</title>
</head>
<body>
<!-- /chap02/mvc/join ���� GET��� ��û�� ������ �� �������� �����ϵ��� ����� ���ÿ� -->
	<h1>ȸ������ ������</h1>
<form action="/chap02/mvc/join" method="POST">
<table>
<tr>
	<th>ID</th>
	<td><input name="user_id"></td>
</tr>
<tr>
	<th>PWD</th>
	<td><input name="user_pwd"></td>
</tr>
<tr>
	<th>name</th>
	<td><input name="name"></td>
</tr>
<tr>
	<th>Date</th>
	<td><input type="date" name="birthday"></td>
</tr>
<tr>
	<th>�����õ���</th>
	<td><input type="checkbox" name="marketing"></td>
</tr>
<tr>
	<td colspan="2"><button type="submit">ȸ������</td>
	
	
</tr>	
</table>
</form>
</body>
</html>