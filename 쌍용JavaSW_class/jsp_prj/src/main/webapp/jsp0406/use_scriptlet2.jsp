<%@page import="java.util.ArrayList"%>
<%@page import="day0406.TestVO"%>
<%@page import="java.util.List"%>
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
<!-- 구구단 전단을 출력 -->
<script type="text/javascript">
$(function() {
	result(i, j){
		alert(i*j);
	}
})
</script>

<style type="text/css">
.td{width:80px; height:40px; border: 1px solid #333}
#tab{border:1px solid #333; border-spacing:0px; vertical-align: center;}
td:hover {
   background-color: #377;
}
</style>
</head>
<body>
<div>

<table id="tab">
	<%for(int i=1; i<10; i++) {%>
		<tr style="border: 1px solid #333;">
		<%for(int j=2; j<10; j++){%>
			<td class="td"><a href="#" onclick="alert(<%=i*j%>)"><%=j%> * <%=i%></a></td>
		<%}%>
		<tr>
	<%}%>
</table>
</div>
<div style="height:20px; margin-top: 10px"> 결과: <span id="output"></span></div>
<br/>
<br/>
<%
List<TestVO> list = new ArrayList<TestVO>();
list.add(new TestVO("정인선", "서울시 강남구 역삼동", 25));
list.add(new TestVO("권용현", "서울시 구로구 구로동", 26));
list.add(new TestVO("강현모", "경기도 수원시 영통구 망포동", 24));
list.add(new TestVO("신유철", "인천시 부평구 부평동", 27));
%>

<table class="table">
<thead>
	<tr>
	<th>번호</th>
	<th>이름</th>
	<th>주소</th>
	<th>나이</th>
	</tr>
	</thead>
	<tbody>
	<% TestVO tv=null;
	for(int i=0; i<list.size(); i++){ 
		tv=list.get(i);
	%>
	
	<tr>
		<td><%=i+1%></td>
		<td><%=tv.getName() %></td>
		<td><%=tv.getAddr() %></td>
		<td><%=tv.getAge()%></td>
	</tr>
	<%} %>
	</tbody>
</table>
</body>
</html>