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
	<h1>�л����� ��ü ������ȸ</h1>
	
<table border="1">
			<tr>
				<td>�й�</td>
				<td>�̸�</td>
				<td>����</td>
				<td>����</td>
				<td>����</td>
				<td>����</td>
				<td>���</td>
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
				<td><a href="/score/delete?stuNum=${stuNum.index+1}">[����]</a></td>
			</tr>
	</c:forEach>

		</table>
	
	<a href="/score/register">�ٸ����� ����ϱ�</a>
	
	<script type="text/javascript">
		const msg="${message}";
		console.log(msg);
		if(msg==="delSuccess"){
			alert("�������� �Ϸ�!");
		}
	</script>
</body>
</html>