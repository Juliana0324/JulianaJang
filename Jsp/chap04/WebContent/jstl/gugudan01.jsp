<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>gugudan01.jsp</title>
</head>
<body>
	<h1>구구단 출력</h1>
<table border="2">
	<tr>
	<th colspan="10">구구단 출력</th>
	</tr>
	
<% 
	for(int i=2; i<10;i++){
		out.print("<tr>"+i+"단");
		for(int j=1;j<10;j++){
			out.print("<td>");
			out.print(i+"*"+j+"="+(i*j)+" "+"</td>");
		}
		out.print("</tr>"+"<br>");
	}
%>
<%	for(int gop =0;gop<=9;gop++){%>
		<tr>
		<% for (int dan=0;dan<=9;dan++){
			if(gop==0){
				
			}else{
				
			}
		}
	}
%>

</table>
<div style="font-size:1.3em;">html과 JAVA코드를 함께섞어 쓰면 매우 지저분하다</div>
</body>
</html>