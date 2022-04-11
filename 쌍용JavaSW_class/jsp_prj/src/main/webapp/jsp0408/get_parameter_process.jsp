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

<% //web parameter받기
//post방식일때 한글이 깨지기 때문에 인코딩해줘야함
	request.setCharacterEncoding("UTF-8");

	String id=request.getParameter("text");
	String password = request.getParameter("password");
	String hidden = request.getParameter("hid");
	String date= request.getParameter("date");
	String file= request.getParameter("file");
	String textArea= request.getParameter("ta");
	String gender = request.getParameter("gender");
	String domain = request.getParameter("domain");
	String check = request.getParameter("flag");
%>

	<ul>
		<li>요청방식: <%=request.getMethod()%></li>
		<li>id: <%=id%></li>
		<li>pass: <%=password%></li>
		<li>hidden : <%=hidden%></li>
		<li>date: <%=date%></li>
		<li>file: <%=file%></li>
		<li>testArea: <%=textArea.replaceAll("\n", "<br/>")%></li>
		<li>>textarea: <textarea style="width:400px; height:100px;"><%=textArea %></textarea></li>
		<li>gender: <%=gender%></li>
		<li>domain: <%=domain%></li>
		<li>check: <%=check%></li>
	</ul>
</body>
</html>

