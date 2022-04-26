<%@page import="java.util.List"%>
<%@page import="org.jdom2.Element"%>
<%@page import="java.net.URL"%>
<%@page import="org.jdom2.Document"%>
<%@page import="org.jdom2.input.SAXBuilder"%>
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
#tab {border:1px solid #333; border-spacing: 0px; margin-bottom: 10px;}
</style>
</head>
<body>
<%
String[] rssTitleList={"속보","정치","경제","사회","국제","문화","연예","스포츠"
		,"풀영상","뉴스랭킹","뉴스룸","아침&amp;","썰전 라이브","정치부회의"};

String[] rssURLList={"https://fs.jtbc.joins.com/RSS/newsflash.xml",
		"https://fs.jtbc.joins.com/RSS/politics.xml",
		"https://fs.jtbc.joins.com/RSS/economy.xml",
		"https://fs.jtbc.joins.com/RSS/society.xml",
		"https://fs.jtbc.joins.com/RSS/international.xml",
		"https://fs.jtbc.joins.com/RSS/culture.xml",
		"https://fs.jtbc.joins.com/RSS/entertainment.xml",
		"https://fs.jtbc.joins.com/RSS/sports.xml"
		,"https://fs.jtbc.joins.com/RSS/fullvideo.xml",
		"https://fs.jtbc.joins.com/RSS/newsrank.xml",
		"https://fs.jtbc.joins.com/RSS/newsroom.xml",
		"https://fs.jtbc.joins.com/RSS/morningand.xml",
		"https://fs.jtbc.joins.com/RSS/ssulzunlive.xml",
"https://fs.jtbc.joins.com/RSS/politicaldesk.xml"};

pageContext.setAttribute("rssTitle",rssTitleList);
%>
<table class="table">
<tr>
<c:set var="i" value="0"/>
<c:forEach var="title" items="${rssTitle}">
		<td><a href="jtbc_rss.jsp?type=${i}"><c:out value="${title}"/></a></td>
<c:set var="i" value="${i+1}">
</c:set>
</c:forEach>
</tr>
</table>
<c:if test="${empty param.type}">보고싶은 뉴스를 클릭해주세요</c:if>
<c:if test="${not empty param.type}">
<c:catch var="e">
<table class="table">
<tr>
<th class="num" style="width:80px">번호</th>
<th class="title" style="width:200px">제목</th>
<th class="link" style="width:150px">링크</th>
<th class="desc" style="width:500px">내용</th>
<th class="pubDate" style="width:80px">날짜</th>
</tr>

<%
//요청값에 해당하는 xml을 요청한다
String type=request.getParameter("type");
String selectURL=rssURLList[Integer.parseInt(type)];

//Builder생성
SAXBuilder sb = new SAXBuilder();

//document객체 얻기
Document doc= sb.build(new URL(selectURL));

//최상위 노드 얻
Element rootNode= doc.getRootElement();

//4. 찾을 노드 얻기 (파싱할 노드로 접근)
Element channelNode=rootNode.getChild("channel");

//5. 자식노드 얻기
List<Element> itemNodes=channelNode.getChildren("item");

//노드에 관한것 다얻기
Element itemNode=null;
Element titleNode=null;
Element linkNode=null;
Element descNode=null;
Element pubDateNode=null;

String title="", link="", desc="", pubDate="";
for(int i=0; i<itemNodes.size(); i++){
	itemNode= itemNodes.get(i); //리스트 i번째 방에 저장된 item노드를 꺼내와서 Element 저장
	titleNode=itemNode.getChild("title");	
	linkNode=itemNode.getChild("link");	
	descNode=itemNode.getChild("description");	
	pubDateNode=itemNode.getChild("pubDate");	
	
	//파싱
	title=titleNode.getText();
	link=linkNode.getText();
	desc=descNode.getText();
	pubDate=pubDateNode.getText();	
	
%>
<tr>
	<td class="num"><%=i+1 %></td>
	<td class="title" ><a href="<%=link%>" target="_new"><%=title %></a></td>
	<td class="link"><%=link %></td>
	<td class="desc"><%=desc%></td>
	<td class="pubDate"><%=pubDate%></td>
</tr>

<% }%>
</table>

</c:catch>
<c:if test="${not empty e}">
<%--예외발생! --%>
죄송합니다. 문제가 발생하였습니다. 잠시 후 다시시도해 주세요.
</c:if>
</c:if>
</body>
</html>