<%@ page import="chap01.servlet.BBS" %>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>�Խ��Ǳ۾��� - �Է�ȭ��</title>
</head>
<body>
<h1>�Է°� �׽�Ʈ</h1>
<form action="/BBS" method="post">
	�̸�: <input type=text name=name><br>
	�������: <input type=date name=birth><br>
	�г�: <input type=number min=1 max=4 step=1 name="grade"><br>
	����ó: <input type=tel name="tel" pattern="^[0][1][0](-| )\d{4}(-| )\d{4}$"><br>
	�̸���: <input type=email name="email"><br>
	���̵�:<input type="text" name="id" size="10" maxlength="10" value="user01"><br>
	��й�ȣ: <input type="password" name="pw" size="10"><br>
	�����ϴ� ����(������ ���ð���):<br>
	<input type="checkbox" name="fruit" value="10">���
	<input type="checkbox" name="fruit" value="20" checked>�� 
	<input type="checkbox" name="fruit" value="30">�� 
	<br>
	����: <br>
	<input type="radio" name="sex" value="m" checked>��
	<input type="radio" name="sex" value="w" checked>��<br>
	
	<br>
	����: 
	<select name="job" size="2">
	<option value="1">�л�
	<option value="2" selected>ȸ���
	<option value="3">��ȣ��
	<option value="4">�ǻ�
	<option value="5">�˻�
	</select><br>
	<br>
	<textarea name="data" cols="50" rows="5">�⺻���� ���⿡ �ֽ��ϴ�. ���鵵 ��Ÿ���ϴ�.</textarea><br>
	<input type="file" name="file"><br>
	<input type="submit" value="����"><br>
	<input type="reset" value="���"><br>
<br>
<br>
</form>
</body>
</html>