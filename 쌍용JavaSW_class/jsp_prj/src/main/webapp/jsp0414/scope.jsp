<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    info="scope 사용"%>
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
<!-- 
page: 요청할때마다 객체를 생성하고 page 객체에 저장 (누적합 불가)
request: 요청할 때 마다 객체를 생성하고 request 객체에 저장 (누적합 불가) - forward 로 이동할때 까지 객체가 유지
session: 웹 브라우저마다 하나의 객체만 생성하고 session 객체에 저장 (사용자마다 다름)
*application: 최초 접속자에의해 하나의 객체만 생성하고 application 객체에 저장-서버ㅏ 종료될때까지 갹체 유지 (사용자같이 사용 가능-접속자 통계 추천) 
-->
<!-- 객체생성 -->
<jsp:useBean id="cVO" class="day0414.CounterVO" scope="session"/>
<jsp:setProperty property="cnt" name="cVO" value="1"/>

당신은 이페이지의 
<strong><img src="imgs/num_1.png"/>번째</strong> 방문자 입니다<br/>

<%
//id는 객체명으로 변경됨으로 jsp코드에서 사용할 수 있습니더,
//cVO.setCnt(1);
log(request.getRemoteAddr());
%>	
당신은 이페이지의 
<strong>

<%
  String cnt = String.valueOf(cVO.getCnt());
  
  for(int i=0; i< cnt.length(); i++){
	  %>
	  	<img src="imgs/num_<%=cnt.charAt(i)%>.png"/>
	  
	  <%
  }
  
%>
  </strong>번째 방문자 입니다.


</body>
</html>