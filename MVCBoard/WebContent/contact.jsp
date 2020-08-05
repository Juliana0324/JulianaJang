<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/default.css" media="screen">
<title>문의 페이지</title>
</head>
<body>
<table>
	<tr height="50"><td>
	<jsp:include page="incl/header.jsp"/>
	</td></tr>
	<tr height="500" valign="top"><td>
	<form action='<c:url value="/Board.do"/>' method="post">
	<fieldset>
	<legend>문의메일</legend>
	<table>
	<tr><td>
	보내시는분<td>
	<td><input type=text name=from value="답장 받으실 메일주소를 적어 주세요."></td>
	</tr>
	<tr>
	<td>수신<td>
	<td><input type=text value="chiang324@naver.com" readonly></td>
	</tr>
	<tr><td>
	제목<td>
	<td><input type=text name=subject></td>
	</tr>
	<tr><td>
	이름<td>
	<td><input type=text value=name></td>
	</tr>
	<tr>
	<td>내용<td>
	<td><textarea name=content cols=15 rows=5>
	문의 내용을 입력해 주세요. 최대한 빨리 답장해 드리겠습니다.</textarea></td>
	</tr>
	<tr>
	<td colspan=2><input type=submit value=메일전송> 
	</tr>
	</table>
	</fieldset>
	<input type=hidden name=action value="contact_do">
	</form>
	<tr height="50"><td>
	<jsp:include page="/incl/footer.jsp"/>
	</td>
	</tr>
</table>
</body>
</html>