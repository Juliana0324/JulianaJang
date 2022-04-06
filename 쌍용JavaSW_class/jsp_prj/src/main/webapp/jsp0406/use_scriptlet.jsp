<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    info="스크립틀렛의 사용"
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="http://211.63.89.147/html_prj/common/css/main_20220321.css"/>
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
td:hover {background-color: #3e3e3f}
</style>
</head>
<body>
<% 
//scriptlet: method내에서 정의하는 java code작성
String msg="";
%>
<div>
	<%msg="오늘은 수요일입니다";%>
	<%=msg%>
</div>
<div>
<%for(int i=0; i<6; i++) {%>
<h<%=i %>><%=msg %></h<%=i %>>
<%}; %>
</div>
<div>
	<select id="year">
		<% int nowYear= Calendar.getInstance().get(Calendar.YEAR);
			int twenty = nowYear-20+1;
		//나이가 20살에 해당하는 옵션을 셀렉트
		for(int i=2022; i>1950; i--) {%>
		<option value="<%=i%>" <%=i==twenty?" selected:'selected'":""%>><%=i%></option>
			<%} %>
	</select>
</div>
<div>
	<select>
	<%for(int i=-2; i<3; i++) {%>
		<option <%= nowYear+i==nowYear?" selected='selected'":"" %>><%=nowYear+i%></option>
		<%} %>
	</select>
</div>

<div>
			<table><tr>
	<%
		String[] name={"정인선","권용현","강현모","신유철","서희수"};
		String imgLoc="";
		for(String n: name){
			imgLoc="../common/imgs/icon.png";
			if(n.equals("권용현")){
				imgLoc="../common/imgs/rabbit.png";
			}
			%>
			<th><img src="<%=imgLoc%>" style="width: 300px; height: 270px;"/></th>
			
		<%}	%>
			</tr>
			<tr>
			<%for(String n: name){ %>
			<td style="background-color: #333; color: white; font-weight: bold; text-align: left;"><%=n%></td>
			<%} %>
			</tr>
			</table>
</div>

<!-- 구구단 전단을 출력 -->
<script type="text/javascript">
$(function() {
	result(i, j){
		alert(i*j);
	}
})
</script>
<div>

<table border="1" style="width: 500px; border-spacing: 3px; margin: 10px; text-align: center; font-size: 20px">
	<%for(int i=1; i<10; i++) {%>
		<tr style="border: 1px solid #333;">
		<%for(int j=2; j<10; j++){%>
			<td style="border: 1px solid #333;"><a href="#" onclick="alert(<%=i*j%>)"><%=j%> * <%=i%></a></td>
		<%}%>
		<tr>
	<%}%>
</table>
</div>
<div style="height:20px; margin-top: 10px"> 결과: <span id="output"></span></div>
</body>
</html>