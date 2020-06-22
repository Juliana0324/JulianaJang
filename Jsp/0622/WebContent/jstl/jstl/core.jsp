<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>jstl/core.jsp</title>
</head>
<body>
<!-- jstl�� ����(Attribute)�� ���� Ȥ�� ���� ���� -->
<c:set var="a" value="8"/>
<p>
	JSTL�� ������ ��: ${a }
</p>
<!-- �ڹٷ� �ϴ¹� (����) -->
<%
	request.setAttribute("b",10);
%>
<p>
	JAVA�� ������ ��: <%=request.getAttribute("b") %>
</p>

<!-- c:if==> ���ΰ�� ����(else if, else�� ����) -->
<c:if test="${a eq 8 }">
<p>
	���� a=8�Դϴ�
</p>
</c:if>
<hr>

<!--  
	c:choose -if
	c:when - else if
	c: otherwise - else

 -->

<c:choose>
	<c:when test="${a gt b }">	<!-- gt==greater than -->
		<p>���� a�� b���� Ů�ϴ�</p>
	</c:when>
	<c:when test="${a < b }">
		<p>���� a�� b���� �۽��ϴ�</p>
	</c:when>
	<c:otherwise>
		<p>���� a�� b�� ���� �����ϴ�</p>
	</c:otherwise>
</c:choose>
<hr>
<!--  
	div: ���� �ٲٴ� ������ ���� �Ѵ�(block ����)
	span: ���� �ȹٲٴ� ������ �����ѵ�(inline ����)
 -->
 <p>block ��ҵ��� <div style='color:red'>���� ���� ��ҵ��� ������</div></p>
 <p>inline ��ҵ��� <span style='color:blue'>���� ���� ��ҵ��� ������</span></p>

<!-- c:out -���ϴ� ������ HTML�����!
	* �ױ׸� ��ȿȭ
 -->


 <c:set var="txt" value="<span style='color:red;'> C:OUT!!</span>"/>
<ol>
	<li>�׳� ���: ${txt }</li>
	<li>c:out���� ���: <c:out value="${txt }" escapeXml="true"/></li>
	<li>c:out���� ���: <c:out value="${txt }" escapeXml="false"/></li>
</ol>
<hr>
<!-- c:forEach-�ݺ���.begin/end Ȥ�� items�̿� -->
<c:forEach var="i" begin="1" end="10">
	<b>Hello ${i }</b><br>
</c:forEach>
<hr>

<!-- c:forTokens - ��ū: apple/banana/.. �������ذ�
		- �����͸� split�ϸ鼭 �ݺ����� �ݺ��ϴ� ���
 -->
 <c:forTokens items="red/tomato/orange/purple/yellow/blue/navy" delims="/" var="color">
 <div style="border:1px solid ${color};">
 	${color } color div</div>
 </c:forTokens>
<hr> 
 
 <!-- c:url - ��θ� ���� ���� �ϼ��� �� �ֵ��� ������
 	��°�� /0622/abc/123/core.jsp
 -->
<c:url value="/abc/123/core.jsp"/><br>

<c:url value="/abc/123/core.jsp">
	<c:param name="id" value="10"/>
	<c:param name="age" value="13"/>
</c:url>
</body>
</html>