<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    info="myBatis 연습"
    %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="http://211.63.89.147/spring_mvc/common/css/main_20220321.css"/>
<!-- bootstrap CDN -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>

<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script type="text/javascript">
$(function() {
	
});//ready
</script>
<style type="text/css">

</style>
</head>
<body>
<ul>
	<li><a href="day0523/scsrFrm.do">칼럼 하나에 행하나 조회</a></li>
	<li><a href="day0524/scmrFrmProcess.do">칼럼 하나에 여러행 조회</a></li>
	<li><a href="day0524/mcsrFrmProcess.do">칼럼 여러개 행하나 조회</a></li>
	<li><a href="day0524/mcmrFrmProcess.do">칼럼 여러개 여러행 조회</a></li>
	<li><a href="day0524/ltFrmProcess.do"> < 조회</a></li>
	<li><a href="day0525/gtFrmProcess.do"> > 조회</a></li>
	<li><a href="day0525/likeFrmProcess.do"> like </a></li>
	<li><a href="day0525/subquery.do"> subquery</a></li>
	<li><a href="day0525/union.do"> union</a></li>
	<li><a href="#void"> join</a></li>
	<li><a href="#void"> subquery + join</a></li>
	<li><a href="#void"> 테이블명이 동적일때</a></li>
	<li><a href="#void"> dynamic query(if)</a></li>
	<li><a href="#void"> dynamic query(choose)</a></li>
	<li><a href="#void"> dynamic query(foreach)</a></li>
</ul>
</body>
</html>