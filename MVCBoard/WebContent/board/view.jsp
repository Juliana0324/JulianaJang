<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="/incl/staticHeader.jsp"/>
<meta charset="UTF-8">
<title>글상세 내용화면</title>
</head>
<body class="page">
<jsp:include page="/incl/header.jsp"/>
<div id="page-banner" style="background-image: url(img/02-screenshot.jpg);">
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
	<h1>상세내용</h1>
	<table class="table table-striped table-bordered">
	<tr>
		<th>작성자 이름</th>
		<td>${board.name}</td>
	</tr>
	<tr>
		<th>제목</th>
		<td>${board.subject}</td>
	</tr>
	<tr>
		<th>내용</th>
		<td>${board.content }</td>
	</tr>
	<tr>
	<td colspan=2><h3 align=center>
	<a href='<c:url value="/Board.do?action=list"/>'>목록</a>
	<a href='<c:url value="/Board.do?action=reply&bbsno=${board.bbsno}"/>'>댓글</a>
	<a href='<c:url value="/Board.do?action=update&bbsno=${board.bbsno}&userid=${board.userId}"/>'>수정</a>
	<a href='<c:url value="/Board.do?action=delete&bbsno=${board.bbsno}&replynumber=${board.replyNumber}&userid=${board.userId}"/>'>삭제</a>
	</h3>
	</td>
	</tr>
	</table>
	</div></div></div></div><div class="clearfix"></div>
		<jsp:include page="/incl/footer.jsp"/>
</body>
</html>
