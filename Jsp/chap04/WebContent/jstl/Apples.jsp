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
<title>사과</title>
<style>
/* table에 스타일 넣기 */
table{
	width: 500px;
}

/* 모든 tr태그 중 짝수 번째 선택*/
tr:nth-child(even){
	background-color: #f56f42;
	color: white;
	opacity: 0.8;
}

tr:nth-child(odd){
	background-color: #406611;
	/*rgb로 받는 법 rgb(00,00,00)*/
	color: white;
	opacity: 0.8;
}

ul{
	list-style-type:none;
}
ul>li{
	display: inline-block;
	width:80px;
}



</style>

</head>
<body>
<table border="2">
<tr>
	<th>사과 정보</th>
</tr>
<c:forEach var="apple" items="${apples }">
	<tr>
	<td>${apple }</td>
	</tr>
</c:forEach>

</table>

</body>
</html>
