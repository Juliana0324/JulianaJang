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

function sendFrm(flag){
	//form테그의 action을 변경가능: document.폼이름.method="GET"|"POST"
	var method="GET";
	if(flag==1){
		method="POST"
	}
	document.frm.method=method;
	
	document.frm.submit();
}
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
		<li>다른 URL요청</li>
		<li><a href="a.do">a.do</a></li>
		<li><a href="b.do">b.do</a></li>
		<li><a href="c.do">c.do</a></li>
		<li>----------------------------------</li>
		<li>응답페이지 처리: 요청명과 jsp명이 같을때<br/>
		<a href="void_return.do">jsp=요청명</a>
		</li>
		
		<li><strong>응답페이지 처리(views하위 폴더)</strong>
		<a href="sub_result.do">요청</a>
		</li>
		<li>forward</li>
		<li>redirect</li>
		<li>----------------------------------</li>
		<li><a href="request_info.do">접속자 정보받기</a></li>
		<li>Web Parameter 요청(HttpServletRequest)
			<a href="use_request.do?name=test&age=20&lang=java&lang=c/c%2B%2B&lang=Python">요청</a>
		</li>
		<li>Web Parameter 요청(단일형)
			<a href="single_param.do?name=test&age=20&lang=java&lang=c/c%2B%2B&lang=Python">요청</a>
		</li>
		<li>Web Parameter 요청(VO)
			<a href="vo_param.do?name=test&age=20&lang=java&lang=c/c%2B%2B&lang=Python">요청</a>
		</li>
		<li>
			web parameter 한글 처리<br/>
			<form action="vo_param.do" name="frm">
				<label>이름</label> <input type="text" name="name" class="inputBox"/><br/>
				<label>나이</label> <input type="text" name="age" class="inputBox"/><br/>
				<label>언어</label> 
				<input type="checkbox" name="lang" value="자바"/>자바<br/>
				<input type="checkbox" name="lang" value="자바스크립트"/>자스 <br/>
				<input type="checkbox" name="lang" value="파이썬"/>파이썬<br/>
				<input type="checkbox" name="lang" value="c언어"/>C언어<br/>
				<input type="button" value="Get전송" onclick="sendFrm(0)" class="btn btn-info"/>
				<input type="button" value="Post전송" onclick="sendFrm(1)" class="btn btn-info"/>
			</form>
		</li>
		<li>
		redirect이동
			<a href="day0512/do_move.do">do요청(Controller)</a>
		</li>
		<li>
		redirect이동
			<a href="day0512/jsp_move.do">jsp요청(Controller)</a>
		</li>
		<li>
		forward이동
			<a href="day0512/forward_a.do">do요청(Controller 직접요청)</a>
		</li>
		<li>
		forward이동
			<a href="day0512/forward_b.do">do요청(Controller)</a>
		</li>
		<li>
			include<br/>
			<a href="day0512/include_views.do">WEB-INF/views</a>
		</li>
		<li>
		include<br/>
			<a href="day0512/include_webapp.do">do</a>
		</li>
		
		
		<li>HttpSession<br/>
			<a href="day0512/session.do">HttpSession</a>
		</li>
		<li>HttpSession<br/>
			<a href="day0512/session.do">@SessionAttribute설정</a>
		</li>
		<li>HttpSession<br/>
			<a href="day0512/session.do">@SessionAttribute 값얻기</a>
		</li>
		<li>HttpSession<br/>
			<a href="day0512/session.do">@SessionAttribute 삭제</a>
		</li>
		<li>Cookie사용</li>
		<li>AJAX</li>
	</ul>
</div>
</body>
</html>