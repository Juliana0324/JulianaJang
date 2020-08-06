<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="/incl/staticHeader.jsp"/>
<meta charset="UTF-8">
<title>글 삭제 화면</title>
</head>
<body class="page">
<jsp:include page="/incl/header.jsp"/>
<div id="page-banner" style="background-image: url(img/04-screenshot.jpg);">
  <div class="content  wow fdeInUp">
    <div class="container ">
      <h1>게시판</h1>
    </div>
  </div>
  </div>
    <div id="page-body">
  <div class="container">
    <div class="row"> 
      <div class="col-md-offset-3 col-md-6 page-block">
	<h1>회원 정보 삭제</h1>
	<h3>삭제 비밀번호 입력</h3>
	<form action='<c:url value="/Member.do"/>' method="post">
	<input type="hidden" name="action" value="${action}">
	<input type="hidden" name="userid" value="${userid}">
	<input type="password" name="password">
	<input type="submit" value="삭 제">
	</form>
		</div></div></div></div><div>
<jsp:include page="/incl/footer.jsp"/>
</div>
</body>
</html>