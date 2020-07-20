<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>서버 에러 페이지</title>
</head>
<body>
<!-- 	<h3>에러원인<%=exception.getMessage() %></h3> -->
<%exception.printStackTrace(); %>
<script>
alert("서버에 에러가 발생하였습니다.")
history.back();
</script>

</body>
</html>