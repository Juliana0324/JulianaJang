<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="/incl/staticHeader.jsp"/>
<title>회원 정보 입력</title>
</head>
<body class="page">
<jsp:include page="/incl/header.jsp"/>
<div id="page-banner" style="background-image: url(img/best-quote.jpg);">
  <div class="content  wow fdeInUp">
    <div class="container ">
<h1>${message }</h1>
</div></div></div>
  <div id="page-body">
	  <div class="container">
    <div class="row"> 
      <div class="col-md-offset-3 col-md-6 page-block">
<h3 align=center>회원정보 입력</h3>
<form action="/MVC/Member.do" method="post">
<fieldset>
<legend>회원 정보</legend>
<table class="table table-striped table-bordered">
<tr>
	<td>아이디</td>
	<td><input type="text" name="userid" value="${member.userId }" ${empty member.userId ? "" :"readonly" }></td>
</tr>
<tr>
	<td>비밀번호</td>
	<td><input type="password" name="password" value="${member.password }"></td>
</tr>
<tr>
	<td>이름</td>
	<td><input type="text" name="name" value="${member.name }"></td>
</tr>
<tr>
	<td>이메일</td>
	<td><input type="text" name="email" value="${member.email }"></td>
</tr>
<tr>
	<td>주소</td>
	<td><input type="text" name="address" value="${member.address }"></td>
</tr>
</table>
	<input type="hidden" name="action" value="${action }">
	<input type="submit" value="저장"><br>
	<input type="reset" value="취소">
</fieldset>
</form>
	</div></div></div></div>
	<div class="clearfix"></div>
<jsp:include page="/incl/footer.jsp"/>
</body>
</html>