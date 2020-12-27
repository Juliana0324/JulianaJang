<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${articles.size() <= 0}">
		<p>게시물이 존재하지 않습니다</p>
    </c:if>	

	<c:if test="${articles.size() > 0}">

	<h2>게시글 목록</h2>
	<table border="2">
		<tr>
			<th>글 번호</th>
			<th>제  목</th>
			<th>작 성 자</th>
			<th>비  고 </th>
		</tr>
		
		<%-- 컨트럴롤러가 가져온 게시글 데이터를 반복문을 이용하여 출력
		만약 게시글 개수가 0개일 경우 대신"게시물이 존재하지 않습니다 출력" 
		비고란에 [삭제]글만 써놓기
		번호는 varStatus를 이용하여 인덱스+1 한값을 매겨주새요
		게시글 작성할 수 있는 링크하나 달아 주세요
		--%>
		<c:forEach var="article" items="${articles}" varStatus="num">
			<tr>
				<td>${num.index+1}</td>
				<td>
					<a href="<c:url value='/board/content?boardNo=${num.index+1}'/>">${article.title}</a>
				</td>
				
				<td>${article.writer}</td>
				
				<td><a href="<c:url value='/board/content?boardNo=${num.index+1}'/>" 
				onclick="return confirm('정말 삭제하시겠습니까?')">[삭제]</a>
				<script>
				const msg = "${message}";
				console.log(msg);
				if(msg === "delSuccess"){
					alert("삭제 완료")
				}
				</script>
				</td>
			</tr>
		</c:forEach>
	</table>
	</c:if>
	<a href="<c:url value='/board/write' />">게시글 작성하기</a>
</body>
</html>