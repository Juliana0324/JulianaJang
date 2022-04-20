<%@page import="kr.co.sist.util.img.ImageResize"%>
<%@page import="java.sql.SQLException"%>
<%@page import="day0419.FileUploadDAO"%>
<%@page import="day0419.UploadFileVO"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@page import="java.io.File"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    info="업로드 처리"
    %>
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
<%
boolean insertFileFlag= (boolean)session.getAttribute("insertFileFlag");

if(!insertFileFlag){
	String ip= request.getRemoteAddr();
	out.print(ip);
	try{
	//form에 enctype="multipart/form-data"라면 FileUpload Component를 사용하여 값을 받는다
	//1. 업로드될 파일의 경로 얻기
	File saveDir= new File("E:/dev/workspace/jsp_prj/src/main/webapp/upload");
	
	//2. 업로드될 파일의 크기
	int fileSize=1024*1024*10;
	
	//3.파일 업로드 컴포넌트
	MultipartRequest mr = new MultipartRequest(request, saveDir.getPath(), fileSize,"UTF-8",new DefaultFileRenamePolicy());
	
	String name= mr.getParameter("name");
	String[] lang= mr.getParameterValues("lang");
	
	String fileName= mr.getParameter("upFile"); //파일명은 파라미터로 얻어지지 않음
	
	String originalName= mr.getOriginalFileName("upFile"); //원본파일명
	String fileSystemName= mr.getFilesystemName("upFile");//FileRenamePolicy클래스에 의해 변경된 이름
	
	pageContext.setAttribute("lang", lang);
	
	UploadFileVO ufVO= new UploadFileVO(0, name, originalName, fileSystemName, ip, "");
	//DB에 추가하기 위한 DAO생성
	FileUploadDAO fuDAO = FileUploadDAO.getInstance();
	
	
	//insert 
	try{
	fuDAO.insertFile(ufVO);
	//리스트에서 보여줄 이미지 생성.
	session.setAttribute("insertFileFlag", true);
	//fileSystemName => 변경된 이름으로
	ImageResize.resizeImage(saveDir.getPath()+"/"+fileSystemName, 80, 60);	
%>

<strong>파일이 업로드 되었습니다.</strong>
이름: <%=name %><br/>
<c:if test="${empty lang}">
선택한 언어 없음<br/>
</c:if>
관심언어: 
<c:forEach var="lang" items="${lang}">
<c:out value="${lang}"/>
</c:forEach>
<br/>
파일명: <%=fileName%><br/>
originalFileName: <%=originalName%><br/>
fileSystem: <%=fileSystemName%><br/>
<a href="../jsp0420/file_list.jsp">이동</a>

<%

	}catch(SQLException se){
		se.printStackTrace();%>
	서비스를 원활히 제공하지 못한 점 뎨동합니다.
	<%
	}
} catch(Exception e){
	%>
	업로드중 예외가 발생했습니다. <%=e %>
	<%
	}
	
}else{
	out.print("새로고침하셨습니다.");
	%>
	<a href="upload_form2.jsp">업로드 폼</a>
	<%
}

%>
</body>

</html>