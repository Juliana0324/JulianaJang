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
	# ����
	1. RequestController�� ���� ������ �����ִ� �޼��� ����
	 - url: /request/quiz : GET
	 - views: /request/req-quiz.jsp
	 - method-name: quiz()
	2. RequestController�� ���۵� ���̵�, ��й�ȣ �Ķ���͸�
	  �޾� �α����� ó���ϴ� �޼��� ����
	 - url: /request/quiz : POST
	 - views: 
	 	������: /request/login-success.jsp
	 	���н�: /request/login-fail.jsp
	 - method-name: quiz()
	3. �α��� ��������: 
	 - id���� : abc1234 , pw: xxx4321
 --%>


	<form action="/quiz" method="post">
		<fieldset>
			<p>
				-ID : <input type="text" name="userId" size="10">
				-PW : <input type="password" name="userPw" size="10">
				<input type="submit" value="�α���">
			</p>
			
		</fieldset>
	</form>

</body>
</html>