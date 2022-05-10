<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	$("#btnPost").click(function() {
		$("#postFrm").submit();
	});
});//ready
</script>
<style type="text/css">
	
</style>
</head>
<body>
<div>
	<ul>
		<li><a href="get.do">GET요청</a></li>
		<li>
		<form action="post.do" method="post" id="postFrm">
			<input type="button" value="POST요청" id="btnPost" class="btn btn-success"/>
		</form>
		</li>
		<li><strong>GET+POST요청</strong>
		<form action="multi.do" method="get">
			<input type="submit" value="Multi-GET요청" class="btn btn-info"/>
		</form>
		<form action="multi.do" method="post">
			<input type="submit" value="Multi-POST요청" id="btnPost" class="btn btn-warning"/>
		</form>
		</li>
		<li>----------------------------------</li>
		<li>응답페이지 처리</li>
		<li><strong>응답페이지 처리(views하위 폴더)</strong>
		<a href="sub_result.do">요청</a>
		</li>
		<li>forward</li>
		<li>redirect</li>
		<li>----------------------------------</li>
		<li>Web Parameter 요청(HttpServletRequest)</li>
		<li>Web Parameter 요청(단일형)</li>
		<li>Web Parameter 요청(VO)</li>
		<li>HttpSession</li>
		<li>Cookie사용</li>
		<li>AJAX</li>
	</ul>
</div>
</body>
</html>