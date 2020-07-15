<%@ page import="chap01.servlet.BBS" %>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>게시판글쓰기 - 입력화면</title>
</head>
<body>
<h1>입력값 테스트</h1>
<form action="/BBS" method="post">
	이름: <input type=text name=name><br>
	생년월일: <input type=date name=birth><br>
	학년: <input type=number min=1 max=4 step=1 name="grade"><br>
	연락처: <input type=tel name="tel" pattern="^[0][1][0](-| )\d{4}(-| )\d{4}$"><br>
	이메일: <input type=email name="email"><br>
	아이디:<input type="text" name="id" size="10" maxlength="10" value="user01"><br>
	비밀번호: <input type="password" name="pw" size="10"><br>
	좋아하는 과일(여러개 선택가능):<br>
	<input type="checkbox" name="fruit" value="10">사과
	<input type="checkbox" name="fruit" value="20" checked>귤 
	<input type="checkbox" name="fruit" value="30">감 
	<br>
	성별: <br>
	<input type="radio" name="sex" value="m" checked>남
	<input type="radio" name="sex" value="w" checked>여<br>
	
	<br>
	직업: 
	<select name="job" size="2">
	<option value="1">학생
	<option value="2" selected>회사원
	<option value="3">변호사
	<option value="4">의사
	<option value="5">검사
	</select><br>
	<br>
	<textarea name="data" cols="50" rows="5">기본값은 여기에 넣습니다. 공백도 나타납니다.</textarea><br>
	<input type="file" name="file"><br>
	<input type="submit" value="저장"><br>
	<input type="reset" value="취소"><br>
<br>
<br>
</form>
</body>
</html>