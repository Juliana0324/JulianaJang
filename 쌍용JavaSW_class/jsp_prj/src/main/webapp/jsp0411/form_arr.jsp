<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page info="배열로 처리하는 HTML form control" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="http://211.63.89.147/jsp_prj/common/css/main_20220321.css"/>
<!-- bootstrap CDN -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>

<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script type="text/javascript">
$(function() {
	$("#btnGet").click(function() {
		$("#getFrm").submit();
	});
	$("#btnPost").click(function() {
		$("#postFrm").submit();
	});
});//ready
</script>
<style type="text/css">
body {margin: 10px;} 
div {width: 400px; border: 1px solid #333; float: left;}

</style>
</head>
<body>
<div id="get">
<strong>GET방식 요청</strong>
<form action="form_arr_process.jsp" method="get" id="getFrm"> <!--form_arr_process.jsp로 submit이 되었을때 이동 -->
	<label>이름</label><input type="text" name="name" class="inputBox"/><br/>
	<label>관심언어</label><br/>
	<input type="checkbox" name="lang" value="java"/>자바<br>
	<input type="checkbox" name="lang" value="C/C++"/>C/C++<br>
	<input type="checkbox" name="lang" value="HTML"/>HTML<br>
	<input type="checkbox" name="lang" value="CSS"/>Css<br>
	<input type="checkbox" name="lang" value="자바스크립트"/>자바스크립트<br>
	<input type="checkbox" name="lang" value="파이썬"/>python<br>
	
	<input type="button" id="btnGet" class="btn btn-success" value="GET요청" />
</form>
</div>
<br/>
<div id="post">
<strong>POST방식 요청</strong>
<form action="form_arr_process.jsp" method="post" id="postFrm"> <!--form_arr_process.jsp로 submit이 되었을때 이동 -->
	<label>이름</label><input type="text" name="name" class="inputBox"/><br/>
	<label>관심언어</label><br/>
	<input type="checkbox" name="lang" value="java"/>자바<br>
	<input type="checkbox" name="lang" value="C/C++"/>C/C++<br>
	<input type="checkbox" name="lang" value="HTML"/>HTML<br>
	<input type="checkbox" name="lang" value="CSS"/>Css<br>
	<input type="checkbox" name="lang" value="자바스크립트"/>자바스크립트<br>
	<input type="checkbox" name="lang" value="파이썬"/>python<br>
	
	<input type="button" id="btnPost" class="btn btn-success" value="Post요청" />
</form>
</div>

</body>
</html>