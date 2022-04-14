<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"
    info="EL에서 사용할 수 있는 연산자"
    %>
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
<div>
<strong>EL에서 지원하는 연산자</strong>
<ul>
	<li>단항</li>
	<li>${2022}</li>
	<li>${-2022}</li>
	<li>!true: ${!true}, not true: ${not true}</li>
	<li>산술</li>
	<li>+: ${4+14}, -: ${4-14}, /: ${14/3}(자바와는 다른 나누기: 실수로 출력!), %: ${14%2}</li>
	<li>관계</li>
	<li>14 > 4: ${14>4} ==> 14 gt 4: ${14 gt 4}</li>
	<li>14 < 4: ${14 < 4} ==> 14 lt 4: ${14 lt 4}</li>
	<li>14>=4: ${14>=4} ==> 14 ge 4: ${14 ge 4}</li>
	<li>14<=4: ${14<=4} ==> 14 le 4: ${14 le 4}</li>
	<li>14==4: ${14==4} ==> 14 eq 4: ${14 eq 4}</li>
	<li>14!=4: ${14!=4} ==> 14 ne 4: ${14 ne 4}</li>
	<li>시프트,&, |,  </li>
	<li>사용불가</li>
	<li>논리</li>
	<li>true&&true: ${true && true} </li>
	<li>false||false: ${false||false} </li>
	<li>삼항</li>
	<li>4는${4%2==0? "짝수":"홀수"}</li>
	
	
</ul>
</div>
</body>
</html>