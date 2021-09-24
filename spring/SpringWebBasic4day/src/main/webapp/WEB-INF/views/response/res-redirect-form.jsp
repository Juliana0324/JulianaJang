<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%-- ResponseController 사용 --%>
<form method="post">
<p>
	# ID: <input type="text" name="userId" size="10"><br>
	# 비밀번호: <input type="password" name="userPw" size="10"><br>
	# 비밀번호 확인: <input type="password" name="userPwChk" size="10"><br>
	<input type="submit" value="로그인">
</p>

</form>
<p style="color:red;">${msg}</p>

</body>
</html>