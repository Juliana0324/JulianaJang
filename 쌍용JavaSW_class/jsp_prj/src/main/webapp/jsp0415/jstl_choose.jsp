<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    info="여러개의 조건을 비교시"
    %>
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
	$("#blood").change(function() {
		$("#frm").submit();
	});
	
	$("#btnScore").click(function() {
		$("#frm2").submit();
	});
});//ready
</script>
<style type="text/css">

</style>
</head>
<body>
<form action="jstl_choose.jsp" id="frm">
<label>혈액형을 선택해주세요</label>
<select name="blood" id="blood">
	<option value="none" ${param.blood eq 'none'?" selected='selected'":""}>===모름===</option>
	<option value="A" ${param.blood eq 'A'?" selected='selected'":""}>A</option>
	<option value="B" ${param.blood eq 'B'?" selected='selected'":""}>B</option>
	<option value="AB" ${param.blood eq 'AB'?" selected='selected'":""}>AB</option>
	<option value="O" ${param.blood eq 'O'?" selected='selected'":""}>O</option>
</select>
</form>
<c:choose>
	<c:when test="${param.blood eq 'A'}">
		<img src="imgs/blood_a.PNG"/>
	</c:when>
	<c:when test="${param.blood eq 'B'}">
	<img src="imgs/blood_b.PNG"/>
	</c:when>
	<c:when test="${param.blood eq 'AB'}">
	<img src="imgs/blood_ab.PNG"/>
	</c:when>
	<c:when test="${param.blood eq 'O'}">
	<img src="imgs/blood_o.PNG"/>
	</c:when>
	<c:otherwise>
	<img src="imgs/default.PNG"/>
	</c:otherwise>
</c:choose>

<div>
<form action="jstl_choose.jsp" id="frm2">
	<label>점수</label>
	<input type="text" name="score" class="inputBox"/>
	<input type="button" value="입력" id="btnScore" class="btn btn-info"/>
</form>
<c:set var="score" value="${param.score }"/>
	<c:if test="${score ge 0 && score le 100}">
		<c:choose>
		<c:when test="${score ge 90}">A</c:when>
		<c:when test="${(score ge 80) and (score le 89)}">B</c:when>
		<c:when test="${(score ge 70) and (score le 79)}">C</c:when>
		<c:when test="${(score ge 60) and (score le 69)}">D</c:when>
		<c:when test="${(score le 50)}">F</c:when>
		</c:choose>
	</c:if>
</div>
</body>
</html>