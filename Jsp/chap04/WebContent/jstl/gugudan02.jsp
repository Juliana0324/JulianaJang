<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>JSTL을 이용해 구구단 출력2</title>
</head>
<body>
<!-- http://tomcat.apache.org/download-taglibs.cgi jstl 여기서 다운받기 -->
<!-- JSTL커스텀 테그 라이브러리, JAVA문법을 간결하게 테그처럼 이용할수 있다-->
<!-- 
	c:forEach: 반복문
	(1) begin부터 end까지 index를 이용해 반복하는 방법
		==>객체
	(2) items에 iterable한 객체를 등록해서 반복하는 방법
		==>배열,arraylist,HashSet...
-->
<!--  c:choose, c:when, c:otherwise: if,else if,else문
	(1): c: choose: 조건문 전체를 가리킴
	(2): c:when :if문 혹은 else if문의 역할을 한다.test속성에 조건문을 넣는다
		*jstl의 비교연산자 : >,<,>=,<=,==,eq,empty,not eq,not empty
		* "	      산술연산자: + - * / %(mod)	
	(3): c:otherwise: else의 역할을 한다.
	
 -->
	<h3>JSTL을 이용해 구구단 출력2</h3>
	<table border="2">
	<c:forEach var="gop" begin="0" end="9">
		<tr>
		<c:forEach var="dan" begin="2" end="9">
			<c:choose>	
				<c:when test="${gop == 0}">
					<th>${dan }단</th>
				</c:when>
				<c:otherwise>
					<td>${gop } x ${dan } = ${gop*dan }</td>
				</c:otherwise>
			</c:choose>
		</c:forEach>
		</tr>
	</c:forEach>
	</table>

</body>
</html>