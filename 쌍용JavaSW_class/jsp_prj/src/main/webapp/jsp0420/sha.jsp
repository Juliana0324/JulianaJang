<%@page import="kr.co.sist.util.cipher.DataDecrypt"%>
<%@page import="kr.co.sist.util.cipher.DataEncrypt"%>
<%@page import="org.apache.tomcat.util.codec.binary.Base64"%>
<%@page import="java.security.MessageDigest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    info="sha 암호화 방식"
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
<%	//일방향
	String plainText="Hello"; //사람이 알아볼수 있는문자열
	//입력되는 알고리즘에 대해 길이가 다른 문자열로 반환
	
	//원래의 문자열로 돌아갈 수 없다. 아무도 확인하지말아야할 정보저장할때
	MessageDigest md= MessageDigest.getInstance("SHA-512");
	md.update(plainText.getBytes());
	String text1 = new String(md.digest());
	
	
	//encoding
	Base64 base = new Base64();
	String text2= new String(base.encode(md.digest()));
%>
	<%=text1 %><br/>
	<%=text2 %><br/>
	
	<%
	
	String text3= DataEncrypt.messageDigest("MD5", plainText);
	%>
	
	<%=text3 %><br/>
	
	<%
	//암복호화 가능한 방법
	//1. 키를 넣어 암호화
	DataEncrypt de = new DataEncrypt(text3);
	String cipher= de.encryption(plainText);
	
	//2. 벅허허ㅣ
	DataDecrypt dd=new DataDecrypt(text3);
	String plain=dd.decryption(cipher);
	%>
	AES로 암호화한 문자열: 
	<%=cipher %><br/>
	
	Key를 사용해 복호화한 문자열:
	<%=plain %><br/>
	
	
</body>
</html>