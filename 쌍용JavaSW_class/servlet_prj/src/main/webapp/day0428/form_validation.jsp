<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- bootstrap CDN -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>

<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script type="text/javascript">
$(function() {
	$("#name").keydown(function(e) {
		if(e.which ==13){
			chkNull();
		}
	});
	
	$("#btn").click(function() {
		chkNull();
	});
});//ready
function chkNull(){
	var name= $("#name").val();
	if(name == ""){
		alert("이름은 필수 입력!");
		$("#name").focus();
		return;
	}
	$("#frm").submit();
}
</script>
<style type="text/css">

</style>
</head>
<body>
<!-- 사용자화면에 키 입력이 가능한 HTML Form Control이 하나라면 
자바스크립트의 유효성 검증이 실패하더라도 Back0end로 전송됨 -->
<form id="frm" action="http://localhost/servlet_prj/form_process" method="get">
<label>입력</label><br/>
<input type="text" name="name" id="name" class="inputBox"/>
<input type="text" style="width:0px; display:none"/>
<input type="button" value="클릭" id="btn" class="btn btn-info"/>
</form>
</body>
</html>