<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="/incl/staticHeader.jsp"/>
<title>${message }</title>
</head>
<body class="page">
<jsp:include page="/incl/header.jsp"/>
<div id="page-banner" style="background-image: url(img/01-screenshot.jpg);">
  <div class="content  wow fdeInUp">
    <div class="container ">
	<h1>${message }</h1>
  </div>
  </div>
  </div>
    <div id="page-body">
	  <div class="container">
    <div class="row"> 
      <div class="col-md-offset-3 col-md-6 page-block">
	<h3 align=center>글 내용을 작성해 주세요</h3>
	<form action='<c:url value="/Board.do"/>' method="post">
		<table class="table table-striped table-bordered">
		<tr><td>제목</td>
		<td><input type="text" name="subject" size="20" value="${board.subject}"></td>
		</tr>	
		<tr><td>비밀번호</td>
		<td><input type="password" name="password" value="${board.password}"></td>
		</tr>	
		<tr><td>내용</td>
		<td><textarea cols="30" rows="5" name="content">${board.content}</textarea></td>
		</tr>	
		<tr>
		<td colspan="2">
		<input type="hidden" name="action" value="${action}">
		<input type="hidden" name="bbsno" value="${board.bbsno}">
		<input type="hidden" name="masterid" value="${board.masterId}">
		<input type="hidden" name="replynumber" value="${board.replyNumber}">
		<input type="hidden" name="replystep" value="${board.replyStep}">
		<input type="hidden" name="userid" value="${board.userId}">
		<input type="submit" value="저 장"> <input type="reset" value="취 소"></td>
		</tr>
		</table>
	</form>
	</div></div></div></div>
	<div class="clearfix"></div>
<jsp:include page="/incl/footer.jsp"/>
</body>
</html>