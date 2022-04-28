<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    info="데이터를 받아와서 사용자에게 보여주는 일"
    %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<div>

<h2>scope객체 사용해야할때(비정상적인 요청이 발생했을때)</h2>
<c:if test="${empty requestScope.site_url}">
		<%=response.sendRedirect("data_process") %>
<%-- 	<c:redirect url="../data_process"/> --%>
</c:if>
<c:forEach var="url" items="${requestScope.site_url}">
	<input type="checkbox" value="${url}"/><c:out value="${url}"/>&nbsp;
</c:forEach>
<input type="text" name="name" value="${requestScope.vo.name}" class="inputBox"/>
<input type="text" name="msg" value="${requestScope.vo.msg}" class="inputBox"/>
</div>
<div>
<h2>scope객체 사용하지 않았을때</h2>
<c:if test="${empty site_url}">
	<c:redirect url="../data_process"/>
</c:if>
<c:forEach var="url" items="${site_url}">
	<input type="checkbox" value="${url}"/><c:out value="${url}"/>&nbsp;
</c:forEach>
<input type="text" name="name" value="${vo.name}" class="inputBox"/>
<input type="text" name="msg" value="${vo.msg}" class="inputBox"/>
</div>
</body>
</html>