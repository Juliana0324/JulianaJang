<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>search-result</title>
</head>
<body>
	<table border="1">
		<tr>
			<td>학번</td>
			<td>국어</td>
			<td>영어</td>
			<td>수학</td>
			<td>총점</td>
			<td>평균</td>
		</tr>
		
		<tr>
			<td>${stu.stuName}</td>
			<td>${stu.kor}</td>
			<td>${stu.eng}</td>
			<td>${stu.math}</td>
			<td>${stu.total}</td>
			<td>${stu.average}</td>
		</tr>
	</table>

<a href="/score/register">다른 점수 등록하기</a>
<a href="/score/list">점수 전체 조회</a>
<a href="/score/search">점수 개별 조회</a>
</body>
</html>