<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    info="foreach를 사용한 배열, List방의 값을 출력"
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
	$("#btn").click(function() {
		$("#frm").submit();
	})
});//ready
</script>
<style type="text/css">

</style>
</head>
<body>
<%String[] names={"강산", "전민정", "정인선", "권용현"}; 
	List<String> subject= new ArrayList<String>();
	subject.add("JSP테그");
	subject.add("내장객체");
	subject.add("액션테그");
	subject.add("EL");
	subject.add("JSTL");

	//scope객체에 저장
	pageContext.setAttribute("names", names);
	request.setAttribute("subject", subject);
%>
<ul>
<li><strong>배열반복</strong></li>
<c:forEach var="name" items="${names}">
	<li><c:out value="${name}"/></li>
</c:forEach>
</ul>
<ul>
<li><strong>리스트반복</strong></li>
<c:forEach var="sub" items="${subject}">
	<li><c:out value="${sub}"/></li>
</c:forEach>
</ul>

<form id="frm" action="jstl_foreach2.jsp">
<c:forEach var="name" items="${names}">
	<input type="checkbox" value="${name}" name="name"/><c:out value="${name}"/>
</c:forEach>
<br/>
<input type="button" value="전송" class="btn btn-info" id="btn"/>
</form>
<c:choose>
	<c:when test="${not empty param.name}">
		<c:forEach var="name" items="${paramValues.name}">
			<c:out value="${name}"/>
		</c:forEach>
	</c:when>
	<c:otherwise>
		선택한 이름이 없습니다.
	</c:otherwise>
</c:choose>

<!-- scope객체에 저장된 subjects를 테이블로 출력 -->
<table>
	<tr>
		<th>번호</th>
		<th>세부과목</th>
	</tr>
	<c:forEach var="sub" items="${subject}">
	<c:set var="i" value="${i+1}" />
	<tr>
		<td><c:out value="${i}"/></td>
		<td><c:out value="${sub}"/></td>
	</tr>
	</c:forEach>
</table>
</body>
</html>