<%@page import="java.util.List"%>
<%@page import="org.jdom2.Element"%>
<%@page import="java.net.URL"%>
<%@page import="org.jdom2.Document"%>
<%@page import="org.jdom2.input.SAXBuilder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String[] rssTitleList={"속보","정치","경제","사회","국제","문화","연예","스포츠"
		,"풀영상","뉴스랭킹","뉴스룸","아침&amp;","썰전 라이브","정치부회의"};

String[] rssURLList={"newsflash.xml",
		"politics.xml",
		"economy.xml",
		"society.xml",
		"international.xml",
		"culture.xml",
		"entertainment.xml",
		"sports.xml"
		,"fullvideo.xml",
		"newsrank.xml",
		"newsroom.xml",
		"morningand.xml",
		"ssulzunlive.xml",
		"politicaldesk.xml"};

// https://fs.jtbc.joins.com/RSS/
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
	$("#rss").change(function() {
		var rss= $("#rss option:selected").val();
		
		if(confirm("뉴스를 확인하시겠습니까?")){
			$.ajax({
				url: "https://fs.jtbc.joins.com/RSS/"+rss,
				data: {"rss":rss},
				type:"get",
				dataType:"xml",
				error:function(xhr) {
					alert(xhr.status);
				},
				success:function(xml){
					var num=0;
					var title="", link="", desc="", pubDate="";
					var output="<tr>";
					$(xml).find("item").each(function(i, itemNode) {
						num+=1;
						
						title=$(itemNode).find("title").text();
						link = rss+$(itemNode).find("link").text();
						desc= $(itemNode).find("description").text();
						pubDate=$(itemNode).find("pubDate").text();
				
						output+= "<td>"+num+"</td>";
						output+= "<td><a href='"+link+"'>"+title+"</a></td><td>"+link+"</td>";
						output+= "<td>"+desc+"</td><td>"+pubDate+"</td></tr>";
					});
					
					$("#news").html(output);
				}
				
			})//ajax
		}//if
		
	});//change
});//ready
</script>
<style type="text/css">
</style>
</head>
<body>

<select id="rss">
	<option value="none">---뉴스선택---</option>
<%for(int i=0; i<rssTitleList.length; i++){ %>
	<option value="<%=rssURLList[i]%>"><%=rssTitleList[i] %></option>
<%} %>
</select>
<table class="table">
<thead>
<tr>
<th class="num" style="width:80px">번호</th>
<th class="title" style="width:200px">제목</th>
<th class="link" style="width:150px">링크</th>
<th class="desc" style="width:500px">내용</th>
<th class="pubDate" style="width:80px">날짜</th>
</tr>
</thead>
<tbody id="news">

</tbody>
</table>
</body>
</html>