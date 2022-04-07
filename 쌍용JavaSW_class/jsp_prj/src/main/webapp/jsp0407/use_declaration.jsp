<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    info="선언의 사용"
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
	
});//ready
</script>
<style type="text/css">

</style>
</head>
<body>
<%!	//declaration은 JSP가 JAVA로 변경될때 클래스필드에 소스코드가 생성됨
	int i;//인스턴스변수 - 자동초기화됨
	public String date(){
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd EEEE");
		return sdf.format(new Date());
}//test
%>
인스턴스 변수 <%=i %>
<%int j=0; //scriptlet(지역변수)=초기화불가 
	String date2=date();
%><br/>

<ul>
	<li>직접호출: <%=date() %></li>
	<li>변수저장: <%=date2 %></li>
</ul>

<%!	//request는 선언에서는 사용하지 못함
	public String createRadio(String radioName,int checked){
	//0-10까지 선택할 수 있는 라디오 버튼 11개를 생성-반환
	StringBuilder value=new StringBuilder();
	
	for(int i=0; i<=10; i++){
		value.append("<input type='radio' value='").append(i).append("' name='").append(radioName).append("'")
		.append(i==checked?" checked='checked'": "").append("/>").append(i)
		.append("점 &nbsp");
	}
		return value.toString();
}
%>
<%=createRadio("a",0)%><br>
<%=createRadio("b",0)%>
</body>
</html>