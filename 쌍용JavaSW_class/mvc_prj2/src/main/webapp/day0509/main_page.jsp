<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    info="scope객체에 할당된 사원 부서정보를보여주는 일"
    %>
    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="http://211.63.89.147/jsp_prj/common/css/main_20220321.css"/>
<!-- bootstrap CDN -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>

<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script type="text/javascript">
$(function() {
	
});//ready
</script>
<style type="text/css">

</style>
</head>
<body>
<div>
<a href="login_form.do?cmd=L001">로그인</a>
</div>
<strong>부서 정보</strong><br/>
<table class="table">
<thead>
	<tr>
		<th>부서번호</th>
		<th>부서명</th>
		<th>위치</th>
	</tr>
</thead>
<tbody>
	<c:if test="${empty deptData}">
	<tr>
		<td colspan="3">부서정보 엄서용
		<br/>
		<img src="http://localhost/mvc_prj2/common/imgs/error.jpg" style="width:120px"/>
		</td>
	</tr>
	</c:if>
	<c:forEach var="deptVO" items="${deptData}">
		<tr>
			<td><c:out value="${deptVO.deptno}"/></td>
			<td><a href="search_emp.do?cmd=I001&deptno=${deptVO.deptno}"><c:out value="${deptVO.dname}"/></a></td>
			<td><c:out value="${deptVO.loc}"/></td>
		</tr>
	</c:forEach>
</tbody>
</table>

<div>
<strong>모든 사원 정보</strong><br/>
<table class="table table-hover">
	<thead>
	<tr>
		<td>사원 번호</td>
		<td>사원명</td>
		<td>직무</td>
		<td>연봉</td>
		<td>매니저번호</td>
		<td>보너스</td>
		<td>부서 번호</td>
		<td>입사일</td>
	</tr>
	</thead>
	<tbody>
		<c:if test="${empty empData}">
		<tr>
		<td colspan="8">사원정보 엄서용
		<br/>
		<img src="http://localhost/mvc_prj2/common/imgs/error.jpg" style="width:120px"/>
		</td>
		</tr>
		</c:if>
		<c:forEach var="empVO" items="${empData}">
			<tr>
				<td><c:out value="${empVO.empno}"/></td>
				<td><c:out value="${empVO.ename}"/></td>
				<td><c:out value="${empVO.job}"/></td>
				<td><c:out value="${empVO.sal}"/></td>
				<td><c:out value="${empVO.mgr}"/></td>
				<td><c:out value="${empVO.comm}"/></td>
				<td><c:out value="${empVO.deptno}"/></td>
				<td><fmt:formatDate value="${empVO.hiredate}" pattern="yyyy-MM-dd"/></td>
			</tr>
		</c:forEach>
	</tbody>
</table>

</div>
</body>
</html>