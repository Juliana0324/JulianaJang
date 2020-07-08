<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>tableLayout.jsp</title>
</head>
<body>
	<table style="margin:auto" width="80%" height="700" border="1" >
	<tr>
		<td colspan="2">
		<jsp:include page="./module/title.jsp"/>
		</td>
	</tr>
	<tr>
		<td width="100" height="200">NAVBAR
				<jsp:include page="./module/nav.jsp"/></td>

		<td>CONTENTS
		<jsp:include page="./module/login.jsp"/>
		</td>
	</tr>
	<tr>
		<td colspan="2" height="80%">	
		<jsp:include page="./module/foot.jsp"/>
</td>
	</tr>
	</table>
</body>
</html>