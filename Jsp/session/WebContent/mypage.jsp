<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지</title>
</head>
<body>
<%if(session.getAttribute("userid")!=null) {%>
<h1 align=center>환영합니다. <%=session.getAttribute("userid") %>님</h1>
<br><br>
<form action="./login" method="post">
<input type=hidden name=action value=logout>
<h3 align=center>로그아웃하시려면 <input type=submit value=logout>을 눌러주세요</h3>
</form>
<br>
<h3 align=center>쿠키를 조회하시려면 <a href="./Cookie.jsp">이곳</a>을 눌러주세요</h3>
<br>
<%} else{
	response.sendRedirect("./Loginform.jsp");
}%>

</body>
</html>