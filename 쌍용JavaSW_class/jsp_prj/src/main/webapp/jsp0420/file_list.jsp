<%@page import="kr.co.sist.util.cipher.DataDecrypt"%>
<%@page import="java.net.URLEncoder"%>
<%@page import="java.net.URI"%>
<%@page import="day0419.UploadFileVO"%>
<%@page import="java.util.List"%>
<%@page import="day0419.FileUploadDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<div style="width:880px">
<a href="http://211.63.89.147/jsp_prj/jsp0419/upload_form.jsp">파일업로드</a>
<table class="table">
<tr>
<th style="width: 80px">번호</th>
<th style="width: 100px">이미지</th>
<th style="width: 300px">파일명</th>
<th style="width: 250px">업로더명/IP addr</th>
<th style="width: 150px">업로드 일자</th>
</tr>
<%
	FileUploadDAO fud = FileUploadDAO.getInstance();
	List<UploadFileVO> listFile =fud.selectList();
	
	DataDecrypt dd= new DataDecrypt("abcdefghijklmn1234");
	for(UploadFileVO ufVO:listFile){
		ufVO.setName(dd.decryption(ufVO.getName()));
	}
	pageContext.setAttribute("listFile", listFile);
%>
<c:if test="${empty listFile}">
<tr>
	<td colspan="5">업로드된 데이터가 존재하지 않습니다
		<img src="http://211.63.89.147/jsp_prj/src/main/webapp/common/imgs/none.png" /><br/>
		<a href="http://211.63.89.147/jsp_prj/jsp0419/upload_form.jsp">업로드 폼</a>
	</td>
</tr>
</c:if>
<c:forEach var="data" items="${pageScope.listFile}">
<c:set var="i" value="${i+1}"/>
<tr>
	<td><c:out value="${i}"/></td>
	<td><img src="http://211.63.89.147/jsp_prj/upload/rs_${data.file_system_name}"/></td>
	<td><a href="http://211.63.89.147/jsp_prj/jsp0420/download.jsp?filename=${data.file_system_name}"><c:out value="${data.file_system_name}"/></a></td>
	<td><c:out value="${data.name}"/> / <c:out value="${data.ip_address}"/></td>
	<td><c:out value="${data.input_date}"/></td>
</tr>
</c:forEach>
<tr>
	<td></td>
	<td></td>
	<td><a href="http://211.63.89.147/jsp_prj/jsp0420/download.jsp?filename=4강의실.hwp">4강의실.hwp</a></td>
	<td></td>
	<td></td>
</tr>
</table>
</div>

</body>
</html>
