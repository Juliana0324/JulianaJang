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
	<h2>ȸ������ ���� ���</h2>
	
	<p>
		# ȸ������: ${user}<br>
		# ���̵�: ${user.userId}<br>
		# ��й�ȣ: ${user.userPw}<br>
		# �̸�: ${user.userName}<br>
		
		#���: 
		<c:if test="${user.hobby.size() != 0}">
			<c:forEach var="h" items="${user.hobby}">
				${h} &nbsp;
			</c:forEach>
		</c:if>
		<c:if test="${empty user.hobby}">
			�� ����� ��̰� �����ϴ�.
		</c:if>
	</p>
</body>
</html>