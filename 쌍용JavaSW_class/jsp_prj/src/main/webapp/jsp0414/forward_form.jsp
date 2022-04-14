<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    info="forward.jsp"
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
	$("#btn").click(function() {
		$("#frm").submit();
	});
	
});//ready
</script>
<style type="text/css">
.kor{color:red; };
.eng{color:blue;}
</style>
</head>
<body>
<%
String serverName= request.getServerName();
String nameLabel="이름";
String ageLabel="나이";
String buttonLabel="전송";
String nameClass="kor";
if(!serverName.equals("localhost")){
	nameLabel = "name";
	ageLabel = "age";
	buttonLabel="submit";
	nameClass="eng";
}

%>

<form action="forward_dist.jsp" method="get" id="frm">
	<label class="<%= nameClass%>"><%=nameLabel %></label><input type="text" name="name" class="inputBox"/><br/>
	<label><%=ageLabel %></label><input type="text" name="age" class="inputBox"/><br/>
	
	<input type="button" value="<%=buttonLabel %>" class="localBtn" id="btn"/>
</form>
<a href="http://localhost/jsp_prj/jsp0414/forward_form.jsp">국내요청</a>
<a href="http://211.63.89.147/jsp_prj/jsp0414/forward_form.jsp" id="overboard">국외요청</a>
</body>
</html>