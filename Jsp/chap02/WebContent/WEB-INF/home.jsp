<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Home</title>
</head>
<body>
	<h1>WEB_INF 밑의 HOME.JSP입니다.</h1>
	<p>
		WEB-INF(WEB INFORMATION)<br>
		WEB-INF의 하위 폴더는 URL을 통해 직접 접근 불가<br>
		내가 설정한 경로로만 들어올수 있음. <br>
		반드시 WAS(웹서버)의 Mapping을 이용해야 접근가능<br>
		Controller의 Redirect 혹은 forward로 매핑된 URL을 이용해 접근<br>
		사용자가 마음대로 웹 사이트의 흐름을 무시할 수 없게 제한 <br>
		
	</p>
</body>
</html>