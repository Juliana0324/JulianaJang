<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri= "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="/incl/staticHeader.jsp"/>
<title>마이페이지</title>
</head>
<body class="page">
<jsp:include page="/incl/header.jsp"/>
<div id="page-banner" style="background-image: url(img/photo-typo.jpg);">
  <div class="content  wow fdeInUp">
    <div class="container ">
      <h1>Contact</h1>
    </div>
  </div>
  </div>
  <div id="page-body">
  <div class="container">
    <div class="row"> 
      <div class="col-md-offset-3 col-md-6 page-block">
<h1>회원정보</h1>
<h3 align=center>회원정보</h3>
	<table class="table table-striped table-bordered">
	<tr>
		<th>아이디</th>
		<td>${member.userId}</td>
	</tr>
	<tr>
		<th>비밀번호</th>
		<td>${member.password}</td>
	</tr>
	<tr>
		<th>이름</th>
		<td>${member.name}</td>
	</tr>
	<tr>
		<th>이메일</th>
		<td>${member.email}</td>
	</tr>
	<tr>
		<th>주소</th>
		<td>${member.address}</td>
	</tr>
	<tr>
		<th>글 갯수</th>
		<td>${count}</td>
	</tr>
	<tr>
		<td colspan=2><a href='<c:url value="/Board.do?action=memberList"/>'>목록 확인</a></td>
	</tr>
	<tr>
		<td colspan=2>
		<h3 align="center">
		<a href="/MVC/Member.do?action=update"><input type="button" value="회원정보 수정"></a>
		&nbsp;&nbsp;
		<a href="/MVC/Member.do?action=delete"><input type="button" value="회원정보 삭제"></a>
		</h3>
		</td>
	</table>
	</div></div></div></div><div class="clearfix"></div>
		<jsp:include page="/incl/footer.jsp"/>

</body>
</html>