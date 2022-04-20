<%@page import="kr.co.sist.util.cipher.DataEncrypt"%>
<%@page import="day0419.FileUploadDAO"%>
<%@page import="day0419.UploadFileVO"%>
<%@page import="kr.co.sist.util.img.ImageResize"%>
<%@page import="java.sql.SQLException"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@page import="java.io.File"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    info="upload처리"
    %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- 공통CSS -->
<link rel="stylesheet" type="text/css" href="http://211.63.89.135/jsp_prj/common/css/main_20220321.css"/>
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
<%-- <%
 // <form enctype="multipart/form-data">라면 parameter가 전송되지 않기 때문에
 // request.getParameter로 HTML Form Control의 입력 값을 받을 수 없다.
 String name= request.getParameter("name");
 String[] lang = request.getParameterValues("lang");
 String fileName= request.getParameter("upFile");
%>
이름 : <%= name %>,(${param.name })<br/>
관심언어 : <%= lang %>,(${paramValues.lang})<br/>
파일명 : <%= fileName %>,(${param.fileName })<br/>
 --%>
 <%
 
 boolean dupFlag=(boolean)session.getAttribute("insertFileFlag");
 
 if(!dupFlag){
 String ip = request.getRemoteAddr();
 out.println(ip);
 // <form enctype="multipart/form-data">라면 FileUpload Component를 사용하여 값을 받는다.
 try{
 // 1. 업로드될 파일의 경로 얻기
File saveDirectory = new File("E:/dev/workspace/jsp_prj/src/main/webapp/upload");
// 2. 업로드될 파일으 ㅣ크기 설정
int fileSize = 1024*1024*10; // 10MByte
 // 3. 파일업로드 컴포넌트 생성
 MultipartRequest mr = new MultipartRequest(request, saveDirectory.getPath(), fileSize, "UTF-8",
       new DefaultFileRenamePolicy());

//파라메터 받기
String name = mr.getParameter("name");
String[] lang = mr.getParameterValues("lang");
pageContext.setAttribute("lang", lang);
String fileName = mr.getParameter("upFile"); // 파일명은 getParameter로 얻어지지 않는다.
String originalName = mr.getOriginalFileName("upFile"); // 원본파일명
String fileSystemName = mr.getFilesystemName("upFile"); // FIleRenamePolicy 클래스에 의해 변환된 이름

//DB에 추가하기위한 VO생성
UploadFileVO ufVO = new UploadFileVO(0, name, originalName, fileSystemName, ip, "");
// DB에 추가하기 위한 DAO생성
FileUploadDAO fuDAO = FileUploadDAO.getInstance();
// insert
try{
//DB에 저장되는 정보의 중요도에 따라 일방향 SHA또는 암호화알고로 변환 수행
//이름을 추후 확인 가능
DataEncrypt de = new DataEncrypt("abcdefghijklmn1234");
ufVO.setName(de.encryption(ufVO.getName()));

//원본파일명은 추후 확인 필요 x
ufVO.setOriginal_name(DataEncrypt.messageDigest("MD5", ufVO.getOriginal_name()));	
fuDAO.insertFile(ufVO);
// 리스트에서 보여줄 이미지를 생성.
ImageResize.resizeImage(saveDirectory.getPath()+"/" + fileSystemName, 80, 60);
session.setAttribute("insertFileFlag", true);
 %>
 파일이 업로드 되었습니다. <br/>
이름 : <%=  name %><br/>
언어 : 
<c:if test="${empty lang }">
선택한 언어 없음.
</c:if>
<c:forEach var="lang" items="${lang }">
<c:out value="${lang }"/>
</c:forEach>
<br/>
파일명 : <%= fileName %>
Original : <%= originalName %>
FileSystem : <%= fileSystemName %>
<a href="../jsp0420/file_list.jsp">이동</a>
<%
 } catch(SQLException se){
    se.printStackTrace();
    %>
    서비스가 원할하지 못한 점 뎨둉합니다.잠시 후 다시 시도.
    <%
 } // end catch
 } catch(Exception e){
    %>
    업로드 중 예외 발생 : <%= e %>
    <%
 } // end catch
 %>
 <a href="upload_form.jsp">업로드 폼</a>
 <%
 } else{
    
    %>
    새로고침
<% 
 }
%>
</body>
</html>