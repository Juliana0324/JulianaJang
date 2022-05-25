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
<form action="http://localhost/spring_mvc/mybatis/day0525/gtFrmProcess.do" method="get">
<label>연봉</label>
<input type="text" name="sal" class="inputBox"/>
<input type="submit" value="전송" class="btn btn-success"/>
</form>
<c:if test="${ empty empList and not empty param.sal}">
<c:out value="${ param.sal }"/>연봉 보다 많은 연봉을 수령하는 사원은<br/>
<img src="http://localhost/spring_mvc/common/imgs/error.jpg" width="250"/><br/>
</c:if>
<c:if test="${ not empty empList }">
<table class="table table-hover">
   <thead>
      <tr>
         <th>사원번호</th>
         <th>사원명</th>
         <th>연봉</th>
         <th>입사일</th>
         <th>부서번호</th>
      </tr>
   </thead>
   <tbody>
   <c:forEach var="empList" items="${empList}">
      <tr>
         <td><c:out value="${ empList.empno }"/></td>
         <td><c:out value="${ empList.ename }"/></td>
         <td><c:out value="${ empList.sal}"/></td>
         <td><fmt:formatDate value="${ empList.hiredate }" pattern="MM-dd-yyyy EEEE"/>
         <td><c:out value="${ empList.deptno }"/></td>
      </tr>
   </c:forEach>
   </tbody>
</table>
</c:if>
<a href="http://localhost/spring_mvc/mybatis/mybatis_index.do">메뉴</a>
</body>
</html>