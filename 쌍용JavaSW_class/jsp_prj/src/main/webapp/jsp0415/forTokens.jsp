<%@page import="java.util.ArrayList"%>
<%@page import="day0407.BloodVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    info="token사ㅏ용"
    %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<%--사용법: 
String csvData="a,b,c,d"
pageContext.setAttribute("data" csvData")

<c:forTokens var="변수명" items="data" delims="구분문자">
 --%>
 
<% 
String csvData="오늘은,금요일,입니다.,내일은,토요일,입니다.,어제는~목요일~이었습니다.";
pageContext.setAttribute("csvData", csvData);
		%> 
<ul>
<c:forTokens var="characters" items="${csvData}" delims="~,.">
	<li><c:out value="${characters}"/></li>
</c:forTokens>	
</ul>

<!-- 문제:  -->

<%
		//imgPath, url, info, int num;
		List<BloodVO> bVO=new ArrayList<BloodVO>();
		bVO.add(new BloodVO(1,"imgs/blood_a.PNG", "http://daum.net", "타인에 대한 배려, 쿨하고싶은 열망"));
		bVO.add(new BloodVO(2,"imgs/blood_b.PNG", "http://naver.com", "아니오 할 수 있는 능력, 내기분"));
		bVO.add(new BloodVO(3,"imgs/blood_ab.PNG", "http://google.com", "감정절제능력, 분석력"));
		bVO.add(new BloodVO(4,"imgs/blood_o.PNG", "http://nate.com", "개그본능, 개그를 할 타이밍을 찾는 능력"));
		
		pageContext.setAttribute("bloodType", bVO);
	%>
	<ul>
	<c:forEach var="blood" items="${bloodType}">
		<li><img src="${blood.imgPath}"/></li>
		
		
	</c:forEach>
	</ul>
</body>
</html>


