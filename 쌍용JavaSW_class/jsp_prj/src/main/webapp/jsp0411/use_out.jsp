<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    info="out의 사용"
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
	alert($("#name").val());
});//ready
</script>
<style type="text/css">

</style>
</head>
<body>

<%
// 줄변경이 안됨
out.print("<div>안녕하세요 ");
out.print("오늘은 월요일</div>");


// 줄변경 가능
out.println("<div>안녕하세요");
out.println("오늘은 월요일</div>");
%>
<input type="text" name="name" id="name"/>
<div>
	<% 
	String[] url= {"daum.net", "google.com", "naver.com", "java.sun.com"};
	for(String value: url){
		out.println("<a href='http://");
		out.println(value);
		out.println("' class='badge bg-primary'>");
		out.println(value);
		out.println("</a>");
		%>
	<%} %>
	

</div>

<div>
	<%for(String value: url){ %>
	<a href="'http://<%= value%>'" class="badge bg-primary"></a>


	<%} %>
</div>
</body>
</html>