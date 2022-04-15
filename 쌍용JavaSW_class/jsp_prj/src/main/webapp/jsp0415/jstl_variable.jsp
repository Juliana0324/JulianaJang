<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    info="jstl변수의 사용 "%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	
});//ready
</script>
<style type="text/css">

</style>
</head>
<body>
	<c:set var="msg" value="오늘은 금요일"/>
	<c:set var="day" value="15"/>
	
	<!-- 출력 -->
	<c:out value="msg"/>
	<c:out value="day"/>
	<br/>
	<!-- EL을 이용해 출력 -->
	<c:out value="${msg}"/>
	<c:out value="${day}"/>
	<br/>
	<!-- 같은 이름의 변수 가능 -->
	<c:set var="msg" value="<strong>오늘은 금요일</strong>입니다"/>
	HTML tag적용되지 않음: <c:out value="${msg}"/><br/>
	EL직접사용 : ${msg}<br/>
	escape xml속성: 
	<c:out value="${msg}" escapeXml="false"/><br/>
	
	<!-- 삭제 -->
	<c:remove var="msg"/>
	msg: <c:out value="${msg}"/><br/>
</body>
</html>