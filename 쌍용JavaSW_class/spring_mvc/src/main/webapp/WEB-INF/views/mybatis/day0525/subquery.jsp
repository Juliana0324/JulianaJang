<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- 공통CSS -->
<link rel="stylesheet" type="text/css" href="http://localhost/spring_mvc/common/css/main_20220321.css"/>
<style type="text/css">
.car_img {width: 80px; height:60px; border:0px;}
</style>
<!-- jQuery CDN -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<!-- bootstrap CDN -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>
<script type="text/javascript">
$(function() {
   
}); // ready
</script>
</head>
<body>
<!-- <form action="http://localhost/spring_mvc/mybatis/day0525/likeFrmProcess.do" method="get">
<label>옵션 검색</label>
<input type="text" name="option" class="inputBox"/>
<input type="submit" value="전송" class="btn btn-success"/>
</form> -->
<c:if test="${ empty carList}">
차량이 존재하지 않습니다.<br/>
<img src="http://localhost/spring_mvc/common/imgs/error.jpg" width="250"/><br/>
</c:if>
<div>
전체 레코드 수 : <c:out value="${totalCnt}"/> <br/>
한화면에 보여줄 게시물 수 : <c:out value="${pageScale}"/> <br/>
총 페이지수 : <c:out value="${pageCnt}"/> <br/>
시작번호: <c:out value="${startNum}"/><br/>
끝 번호: <c:out value="${endNum}"/><br/>
</div>

<c:if test="${ not empty carList }">
<table class="table table-hover">
   <thead>
      <tr>
         <th>번호</th>
         <th>이미지</th>
         <th>차량명</th>
         <th>연식</th>
         <th>가격</th>
         <th>옵션</th>
         <th>연도</th>
      </tr>
   </thead>
   <tbody>
   <c:forEach var="carList" items="${carList}" varStatus="vs">
   <c:set var="i" value="${i+1}"/>
      <tr>
      	<td><c:out value="${totalCnt-(vs.index+startNum)+1 }"/></td>
         <td><img src="http://localhost/spring_mvc/common/car_img/${carList.car_img}" class="car_img"/></td>
         <td><c:out value="${ carList.model }"/></td>
         <td><c:out value="${ carList.car_year }"/></td>
         <td><c:out value="${ carList.price}"/></td>
         <td><c:out value="${ carList.car_option}"/></td>
         <td><c:out value="${ carList.hiredate }"/></td>
      </tr>
   </c:forEach>
   </tbody>
</table>
<div id="pageNation" style="text-align: center;">
	<c:forEach var="i" begin="1" end="${pageCnt}" step='1'>
		[<a href="http://localhost/spring_mvc/mybatis/day0525/subquery.do?currentPage=${i}"><c:out value="${i}"/></a>]
	</c:forEach>

</div>
</c:if>
<a href="http://localhost/spring_mvc/mybatis/mybatis_index.do">메뉴</a>
</body>
</html>