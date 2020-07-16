<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP인풋 예제</title>
</head>
<body>
<form action="/inputResult.jsp" method="post">
이름: <input type=text name=name><br>
연락처 <input type=text name=tel><br>
<input type=submit value="저장">
</form>

</body>
</html>