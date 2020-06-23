<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h2>addStudentController01</h2>
<p> Form에서 자바빈 객체를 이용하고자 할 때 주의할점 <br>
	-자바빈 객체에서 사용한 변수명과 input테그의 name을 동일하게 설정해야한다
</p>


<form action="./addStudentController01.jsp" method="POST">
<table>
<tr>
	<th>이름</th>
	<td><input name="name" placeholder="이름을 입력하세요" required></td>
</tr>
<tr>
	<th>나이</th>
	<td><input name="age" placeholder="나이를 입력하세요" required></td>
</tr>
<tr>
	<th>국어</th>
	<td><input name="kor" placeholder="국어점수를 입력하세요" required></td>
</tr>
<tr>
	<th>영어</th>
	<td><input name="eng"placeholder="영어점수를 입력하세요" required></td>
</tr>
<tr>
	<th>수학</th>
	<td><input name="math" placeholder="수학 점수를 입력하세요" required></td>
</tr>
<tr>
	<td><input type="submit" value="전송!"></td>
	<td><button onclick="">전송2</button></td>
</tr>
</table>
</form>


<h2>addStudentcontroller02</h2>

<form action="./addStudentController02.jsp" method="POST">
<table>
<tr>
	<th>이름</th>
	<td><input name="name" placeholder="이름을 입력하세요" required></td>
</tr>
<tr>
	<th>나이</th>
	<td><input name="age" placeholder="나이를 입력하세요" required></td>
</tr>
<tr>
	<th>국어</th>
	<td><input name="kor" placeholder="국어점수를 입력하세요" required></td>
</tr>
<tr>
	<th>영어</th>
	<td><input name="eng"placeholder="영어점수를 입력하세요" required></td>
</tr>
<tr>
	<th>수학</th>
	<td><input name="math" placeholder="수학 점수를 입력하세요" required></td>
</tr>
<tr>
	<td><input type="submit" value="전송!"></td>
	<td><button onclick="">전송2</button></td>
</tr>
</table>
</form>

<h2>addStudentController03</h2>

<form action="./addStudentController03.jsp" method="POST">
<table>
<tr>
	<th>이름</th>
	<td><input name="name" placeholder="이름을 입력하세요" required></td>
</tr>
<tr>
	<th>나이</th>
	<td><input name="age" placeholder="나이를 입력하세요" required></td>
</tr>
<tr>
	<th>국어</th>
	<td><input name="kor" placeholder="국어점수를 입력하세요" required></td>
</tr>
<tr>
	<th>영어</th>
	<td><input name="eng"placeholder="영어점수를 입력하세요" required></td>
</tr>
<tr>
	<th>수학</th>
	<td><input name="math" placeholder="수학 점수를 입력하세요" required></td>
</tr>
<tr>
	<td><input type="submit" value="전송!"></td>
	<td><button onclick="">전송2</button></td>
</tr>
</table>
</form>
</body>
</html>
