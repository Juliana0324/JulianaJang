<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="/incl/staticHeader.jsp"/>
<title>로그인 화면</title>
</head>
<body class="page">
<jsp:include page="/incl/header.jsp"/>
<div id="page-banner" style="background-image: url(img/01-screenshot.jpg);">
  <div class="content  wow fdeInUp">
    <div class="container ">
	<h1>로그인</h1>
  </div>
  </div>
  </div>
   <div id="page-body">
	  <div class="container">
    <div class="row"> 
      <div class="col-md-offset-3 col-md-6 page-block">
		<c:if test="${!empty message }">${message }</c:if>
		<h2></h2>
		<h3>아이디와 비밀번호를 입력하세요.</h3>
		<form action='<c:url value="/Login.do"/>' method="post">
			<input type="text" name="userid"><br>
			<input type="password" name="password">
		<input type="submit" value="로그인">
		</form>
	</div></div></div></div>
	<div class="clearfix"></div>
<jsp:include page="/incl/footer.jsp"/>
</body>
</html>