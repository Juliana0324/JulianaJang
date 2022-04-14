<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<%
String like= request.getParameter("flag");
Object temp = session.getAttribute("like");
boolean sessionLike = false;
if(temp !=null){
	sessionLike=(boolean)session.getAttribute("like");
}
%>
<table>
<tr>
<td>
12일(현지시간) AP·로이터통신은 친러시아 성향의 야당 지도자 빅토르 메드베드추크를 특수 작전 끝에 체포 했다고 전했다.<br/>
볼로디미르 젤렌스키 우크라이나 대통령은 텔레그램을 통해 메드베드추크가 수갑을 찬 사진을 공개했다. <br/>
젤렌스키 대통령은 “보안국이 특별 작전을 잘 수행했다. <br/>세부 사항은 추후 공개될 것”이라고 말했다.

앞서 우크라이나 당국은 지난 2월 24일 러시아가 <br/>
우크라이나를 침공하자 친러 성향을 가진 그에게 가택 연금 조처를 내린 바 있다. <br/>
하지만 그는 3일 만에 탈출했다.<br/>

우크라이나 재벌로 알려진 그의 행방은 이날 체포 소식 전까지 알려진 바 없었다.<br/>

메드베드추크는 블라디미르 푸틴 러시아 대통령과 친분이 있으며 <br/>
푸틴 대통령은 메드베드추크 딸의 대부로 알려졌다.
</td>
</tr>

<tr>
	<td id="likeImg">이 뉴스가 관심이 있다면 클릭해주세요. 
	<% if(!sessionLike) {%>
	<a href="use_session.jsp?flag=like"><img src="imgs/like.png"/></a>
	<%} else{%>
		<strong>좋아요를 선택하셨습니다.</strong>
	<%} %>
	</td>
	<!-- 좋아요는 이브라우저가 실행되어있는동안 한번만 클릭할 수 있다. -->
</tr>

</table>
</body>
</html>