<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    info="파일업로드 시 form테그"
    %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	session.setAttribute("insertFileFlag", false);
%>
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
	$("#btn").click(function name() {
		var name=$("name").val();
		
		if(name==""){
			alert("이름입력필수!");
			$("#name").focus();
			return;
		}
		
		//선택한 파일의 확장자는 png, jpg, jif, emp만 가능
		//업로드 파일은 img파일만 가능 
		//그렇지 않으먄 alert창
		var fileName= $("#upFile").val();
		var lastIndex = fileName.lastIndexOf(".");
		let ext = fileName.toLowerCase().substring(lastIndex+1, fileName.length);
		var flag= false;
		var imgType="png,jpg,jif,emp".split(",");
		for(var i=0;i<imgType.length; i++){
			if(imgType[i]==ext){
				flag=true;
				break;
			}
		}
		if(!flag){
			alert(fileName+"은 업로드 불가합니다.\n 이미지만 업로드 가능합니다\n 가능확장자 : png,jpg,jif,emp");
			return;
		}
		
		$("#frm").submit();
	});
});//ready
</script>
<style type="text/css">

</style>
</head>
<body>
<%
	String[] lang={"java", "python", "php", "ASP", "jsp", "vb", "c/c++"};
	pageContext.setAttribute("lang", lang);
%>
<form method="POST" enctype="multipart/form-data" action="upload_process.jsp" name="frm" id="frm">
  <label>업로더명</label>
  <input type="text" name="name" id="name" class="inputBox"/><br/>
  <label>관심언어</label>
  <c:forEach var="lang" items="${lang}">
  <input type="checkbox" name="lang" id="lang" value="${lang}" class="inputBox"/><c:out value="${lang}"/>
  </c:forEach><br/>
  <label>파일선택: </label>
  <input type="file" name="upFile" id="upFile" class="inputBox"	style="width:300px"/><br/>
  <input type="button" value="전송" id="btn" class="btn btn-info"/>
</form>
</body>
</html>