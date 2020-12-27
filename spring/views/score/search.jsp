<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>개별점수 조회</h2>
	
	<%--
		- /selectOne 요청을 통해 해당학번을 가진 학생의 성적정보를 조회하여 search-result.jsp에 출력
	 --%>
	<form action="<c:url value='/score/selectOne' />">
		<p>
			#조회할 학번: <input name="stuNum" size="10">
			<input type="submit" value="확인">
		</p>
	</form>
	<%--해당학번에 일치하는 학생의 정보가 없는경우 "학생정보가 없습니다." 띄우세요 --%>
	<p style="color: red;">${msg}</p>
</body>
</html>