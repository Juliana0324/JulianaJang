<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>JSTL�� �̿��� ������ ���2</title>
</head>
<body>
<!-- http://tomcat.apache.org/download-taglibs.cgi jstl ���⼭ �ٿ�ޱ� -->
<!-- JSTLĿ���� �ױ� ���̺귯��, JAVA������ �����ϰ� �ױ�ó�� �̿��Ҽ� �ִ�-->
<!-- 
	c:forEach: �ݺ���
	(1) begin���� end���� index�� �̿��� �ݺ��ϴ� ���
		==>��ü
	(2) items�� iterable�� ��ü�� ����ؼ� �ݺ��ϴ� ���
		==>�迭,arraylist,HashSet...
-->
<!--  c:choose, c:when, c:otherwise: if,else if,else��
	(1): c: choose: ���ǹ� ��ü�� ����Ŵ
	(2): c:when :if�� Ȥ�� else if���� ������ �Ѵ�.test�Ӽ��� ���ǹ��� �ִ´�
		*jstl�� �񱳿����� : >,<,>=,<=,==,eq,empty,not eq,not empty
		* "	      ���������: + - * / %(mod)	
	(3): c:otherwise: else�� ������ �Ѵ�.
	
 -->
	<h3>JSTL�� �̿��� ������ ���2</h3>
	<table border="2">
	<c:forEach var="gop" begin="0" end="9">
		<tr>
		<c:forEach var="dan" begin="2" end="9">
			<c:choose>	
				<c:when test="${gop == 0}">
					<th>${dan }��</th>
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