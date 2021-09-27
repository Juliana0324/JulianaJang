<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>학생들의 전체 성적조회</h1>
	
<table border="1">
			<tr>
				<td>학번</td>
				<td>이름</td>
				<td>국어</td>
				<td>영어</td>
				<td>수학</td>
				<td>총점</td>
				<td>평균</td>
			</tr>
	<c:forEach var="stu" items="${sList}" varStatus="stuNum">
	
			<tr>
				<td>${stuNum.index+1}</td>
				<td>${stu.stuName}</td>
				<td>${stu.kor}</td>
				<td>${stu.eng}</td>
				<td>${stu.math}</td>
				<td>${stu.total}</td>
				<td>${stu.average}</td>
				<td><a href="/score/delete?stuNum=${stuNum.index+1}">[삭제]</a></td>
			</tr>
	</c:forEach>

		</table>
	
	<a href="/score/register">다른점수 등록하기</a>
	
	<script type="text/javascript">
		const msg="${message}";
		console.log(msg);
		if(msg==="delSuccess"){
			alert("점수삭제 완료!");
		}
	</script>
</body>
</html>