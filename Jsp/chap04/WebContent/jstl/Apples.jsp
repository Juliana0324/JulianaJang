 <%@ page import="java.util.ArrayList,chap01.tuto.Apple"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
  
    <% ArrayList<Apple> apples =new ArrayList<>();
    
    for(int i=0;i<10;i++){
    	apples.add(new Apple());
    	
    }
    request.setAttribute("apples", apples);
    
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<table border="2">
<th>사과 정보</th>
<c:forEach var="apple" items="${apples }">
	<tr>
	<td>${apple.size }</td>
	<td>${apple.weight }</td>
	<td>${apple.color[apple.colors] }</td>
	<td>${apple.location[apple.loc] }</td>
	</tr>


</c:forEach>

</table>

</body>
</html>