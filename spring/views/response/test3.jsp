<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>test3</title>
</head>
<body>
	<h2>회원가입정보 출력하기</h2>
	<p>
		# 회원의 전체 정보 : ${user}<br>
		# ID: ${user.userId} <br>
		# 비밀번호: ${user.userPw} <br>
		# Name: ${user.Name} <br>
		# 취미: 
		<c:if test="${user.hobby != null}">
			<c:forEach var="h" items="${user.hobby}">
				${n} &nbsp;
			</c:forEach>
		</c:if>	
		<c:if test="${user.hobby == null}">
			${user.userId}님은 취미가 없습니다.
		</c:if>
	</p>
</body>
</html>