<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    info="parameter를 받기위한 jsp"
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
<!-- VO생성 -->
<% request.setCharacterEncoding("UTF-8"); %>
<jsp:useBean id="pv" class="day0413.ParamVO"/>
<!-- 파라미터 받아오기 -->
<jsp:setProperty property="*" name="pv"/>
<%=pv %><br/>
text: <jsp:getProperty property="text" name="pv"/><br/>
text: <%=pv.getText() %>
password: <jsp:getProperty property="text" name="pv"/><br/>
hidden: <jsp:getProperty property="hid" name="pv"/><br/>
date: <jsp:getProperty property="date" name="pv"/><br/>
file: <jsp:getProperty property="file" name="pv"/><br/>
gender: <jsp:getProperty property="gender" name="pv"/><br/>
domain: <jsp:getProperty property="domain" name="pv"/><br/>
flag(on/null): <jsp:getProperty property="flag" name="pv"/><br/>
<!-- 배열 -->
loc: <jsp:getProperty property="loc" name="pv"/><br/>
<%
String[] loc = pv.getLoc();
if(loc!=null){
	for(String location: loc){
		out.print(location+" ");
	}
}
%><br/>
age: <jsp:getProperty property="age" name="pv"/><br/>

</body>
</html>