<%@page import="day0406.TestVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    info="JSP tag중 표현식 사용"%>
    <%TestVO tv=new TestVO("전민정","서울시 강남구 역삼동",25); %>
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
	$("#btn").click(function() {
		$("#name1").val('<%= tv.getName()%>');
		$("#addr1").val('<%= tv.getAddr()%>');
		$("#age1").val(<%= tv.getAge()%>);
	});
});//ready
</script>
<style type="text/css">

</style>
</head>
<body>
<%
	String name="test";
	System.out.println(name);
	log(name);
	
	String addr="서울시 강남구 역삼동";
%>
<%-- <%=name, addr %> --%>

<div>
<label>이름</label>
<input type="text" name="name" id="name" class="inputBox" value="<%=tv.getName()%>"/><br/>
<label>주소</label>
<input type="text" name="addr" id="addr" class="inputBox" value="<%=tv.getAddr()%>"/><br/>
<label>나이</label>
<input type="text" name="age" id="age" class="inputBox" value="<%=tv.getAge()%>"/><br/>
</div>
<div>
<label>이름</label>
<input type="text" name="name1" id="name1" class="inputBox" /><br/>
<label>주소</label>
<input type="text" name="addr1" id="addr1" class="inputBox" /><br/>
<label>나이</label>
<input type="text" name="age1" id="age1" class="inputBox" /><br/>

<input type="button" value="JS값설정" id="btn" class="btn"/>
</div>
</body>
</html>