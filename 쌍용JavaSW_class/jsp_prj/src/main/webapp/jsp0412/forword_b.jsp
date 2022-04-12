<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    info="디자인 집중"%>

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
<img src="../common/imgs/daum_logo.png"/>
<br/>
<%
	String[] names=(String[])request.getAttribute("names");
	List<String> list = (List<String>)request.getAttribute("object");
	
	if(names==null){
		//처리된 데이터가 없음
		//1. 데이터를 ㅓㅊ리하는 페이지 문제 발생, 2.forward_b.jsp 를 직접호출
		response.sendRedirect("forword.jsp");
		return;
	}
	
	for(String name: names){
		%>
	<input type="radio" value="<%=name%>" name="names"/><%=name %>	
	<%}%>
	<br/>
	<table>
	<tr>
	<th style="width:200px;">번호</th>
	<th style="width:200px;">내장객체</th>
	</tr>
	<% 
	for(int i=0; i<list.size(); i++){%>
	<tr>
		<td><%=list.get(i) %></td>
	</tr>
	<%
	}
	%>
</table>
</body>
</html>
