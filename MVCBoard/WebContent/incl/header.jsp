<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<nav id="top-menu" class="navbar navbar-default navbar-fixed-top">
  <div class="container"> 
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"> <span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span> </button>
      <a class="navbar-brand" href="/MVC/Board.do?action=list"><img src="img/logo-top.png" class="img-responsive"><span>JSP Example Page</span></a> </div>
    
    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1"> 
      
      <!--nav icon--> 
      <a id="nav-icon"> <span></span> <span></span> <span></span> </a> 
      <!--nav icon end-->
      <c:choose>
 	<c:when test="${!empty userid }">
      <ul id="nav-top" class="nav navbar-nav navbar-right">
		   <li><a href="/MVC/Board.do?action=write" class="page-scroll">글 작성</a></li>
			<li><a href="/MVC/Board.do?action=list" class="page-scroll">글 목록</a></li>
			<li><a href="/MVC/Login.do?action=logout" class="page-scroll">로그아웃</a></li>
			<li><a href="/MVC/Board.do?action=member" class="page-scroll">마이페이지</a></li>
      </ul>
	 	<br><br><br><br><font size=3 color="white"><B>${name}님 환영합니다.</B></font>
	 	</c:when>
 		<c:when test="${empty userid}">
	    <ul id="nav-top" class="nav navbar-nav navbar-right">
			<li><a href="/MVC/Member.do?action=insert" class="page-scroll">회원가입</a></li>
			<li><a href="/MVC/login.jsp" class="page-scroll">로그인</a></li>
		</ul>	 	
		</c:when>	 	
      </c:choose>
      
    </div>
    <!-- /.navbar-collapse --> 
  </div>
  <!-- /.container-fluid --> 
</nav>