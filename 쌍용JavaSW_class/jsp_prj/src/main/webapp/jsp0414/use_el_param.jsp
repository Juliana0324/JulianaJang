<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    info="파라미터 사용"
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

</style>
</head>
<body>
<!-- 링크를 눌렀을때 nick에는 test가 age는 25가 전송되는 하이퍼링크를 작성-->
<form action="use_el_param.jsp" id="frm">
<label>nick</label>
<input type="text" name="nick" value="test" class="inputBox"/><br/>
<label>age</label>
<input type="text" name="age" value="25" class="inputBox" /><br/>
<input type="text" name="name" value="a" class="inputBox" /><br/>
<input type="text" name="name" value="b" class="inputBox" /><br/>
<input type="text" name="name" value="c" class="inputBox" /><br/>
<input type="button" value="전송" id="btn"/>
</form>

<a href="use_el_param.jsp?nick=test&age=25&name=a&name=b&name=c">전송</a>
<div>
<!-- el은 널을 출력하지 않음 -->
닉: <strong>${param.nick}</strong>
나이: <strong>${param.age}</strong>
이름: <strong>${param.name}</strong>
이름: <strong>${paramValues.name[0]}</strong>
이름: <strong>${paramValues.name[1]}</strong>

<br/>
닉: <strong><%=request.getParameter("nick") %></strong>
나이: <strong><%=request.getParameter("age") %></strong>
</div>

<span style="color:red">${empty param.flag ?"아래링크를 클릭":""}</span>
입력값: ${param.flag} 
<a href="use_el_param.jsp?flag=true">전송</a>
</body>
</html>