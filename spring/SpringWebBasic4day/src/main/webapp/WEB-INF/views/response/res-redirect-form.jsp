<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%-- ResponseController ��� --%>
<form method="post">
<p>
	# ID: <input type="text" name="userId" size="10"><br>
	# ��й�ȣ: <input type="password" name="userPw" size="10"><br>
	# ��й�ȣ Ȯ��: <input type="password" name="userPwChk" size="10"><br>
	<input type="submit" value="�α���">
</p>

</form>
<p style="color:red;">${msg}</p>

</body>
</html>