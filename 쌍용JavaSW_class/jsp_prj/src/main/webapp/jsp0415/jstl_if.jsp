<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    info="단일if사용"
    %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
//입력된 id가 admin이라면 "관리자"로그인 alert
/* if(window.location.href=="http://localhost/jsp_prj/jsp0415/jstl_if.jsp?id=admin"){
	alert("관리자");
} */

<c:if test="${param.id eq 'admin'}">
alert("관리자");
</c:if>
$(function() {
	$("#btn").click(function() {
		
		$("#frm").submit();
	});
});//ready
</script>
<style type="text/css">

</style>
</head>
<body>
<c:if test="false">
안녕하세요?
</c:if>
<form name="frm" id="frm">
<!-- form테그의 action속성을 생략하면 자신페이지로 요청보냄 -->
<label>아이디</label>
<input type="text" name="id" class="inputBox"/><br/>
<input type="button" value="입력" id="btn" class="localBtn"/><br/>
</form>

<!-- 입력된 아이디를 출력하고 만약 입력된 아이디가 admin인 경우에는 
	버튼 클래스: btn btn-primary 
	
 -->
<c:if test="${param.id eq 'admin'}">
<button type="button" class="btn btn-primary">
관리자: <span class="badge bg-secondary"> 4</span>
</button>
</c:if>
<c:out value="${param.id}"/>


</body>
</html>