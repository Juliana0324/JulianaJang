<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%--
1. res-quiz ������ ȭ��ó���� �� �� �ִ� �޼��带 �����ϼ���.(res-quiz ����)
2. ���±��� �׼�URL�� res-login ���� �����ϼ���.
3. ID:kim123, PW:kkk1234 ��� res-quiz-success.jsp�������� 
     �̵��ؼ� "�α��� ����" "(ȸ��ID)�� ȯ���մϴ�" ���
4. �ƴ϶�� res-quiz-fail.jsp�������� �̵��ؼ� 
   "�α��� ����" "(ȸ��ID)�� ȸ���� �ƴմϴ�" ���
	
--%>
	
	<form action="/response/res-login" method="POST">
		<fieldset>
			<legend>�α���</legend>
			<p>
				ID: <input type="text" name="userId" size="10"><br>
				PW: <input type="password" name="userPw" size="10"><br>
				
				<input type="submit" value="�α���">
			</p>
		</fieldset>
	</form>


</body>
</html>