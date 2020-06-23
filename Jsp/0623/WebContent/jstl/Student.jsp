<%@ page import ="java.util.HashSet, chap01.beans.Student" %>

<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    

<% HashSet<Student> students = new HashSet<>();
	for(int i=0; i<10; i++){
		students.add(new Student());
	}
	request.setAttribute("students",students);


%>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style>\
/*class �Ӽ� ����Ͽ� �θ���*/
.center{
	text-align:center;
}

</style>

</head>
<body>
<h3>�л����� </h3>

<p>getter/setter�� ������ �ڹ� ��ü�� EL�� ���� ���ϰ� �̿��� �� �ִ�</p>
<c:forEach var="student" items="${students }">
<table class="center" border="1">
	<tr>
		<th width="100">�̸�</th>
		<td width="300" colspan="2">${student.name }</td>
	</tr>
	<tr>
		<th width="33.33%">����</th>
		<th width="33.33%">����</th>
		<th width="33.33%">����</th>
	</tr>
	<tr>
		<td>${student.kor }��</td>
		<td>${student.eng }��</td>
		<td>${student.math }��</td>
	</tr>
	<tr>
		<th colspan="3">�������</th>
	</tr>
	<tr>

		<td colspan="3">${student.avg }</td>
	</tr>
	<tr>
		<th height="100" width="30">���</th>
		<td colspan="2"></td>
	</tr>

</table>
<br>
<br>
</c:forEach>

</body>
</html>