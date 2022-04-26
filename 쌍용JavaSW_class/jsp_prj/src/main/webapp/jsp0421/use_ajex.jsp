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
	$("#html").click(function() {
		$.ajax({
			url:"ajax.html",
			async:true,
			dataType:"html",
			error:function(xhr){
				alert("문제발생"+xhr.status+", "+xhr.statusText);
			},
			success:function(data){				
				$("#result").html(data);
			}
		});
	});//html click
	
	$("#text").click(function() {
		$.ajax({
			url:"ajax.txt",
			async:true,
			dataType:"text",
			error:function(xhr){
				alert("문제발생"+xhr.status+", "+xhr.statusText);
			},
			
			success:function(data){
				//호이스팅 
				let output="<ul>";
				
				/*data==> csv데이터  */
				var arr=data.split(",");
				for(var i=0; i<arr.length; i++){
					output+= "<li>"+arr[i]+"</li>"
				}
				output+="</ul>"
				
				$("#result").html(output);
			}
		})
	});// text click;
	
	$("#xml").click(function() {
		$.ajax({
			url:"ajax.xml",
			dataType:"xml",
			error:function(xhr){
				console.log("문제발생"+xhr.status+", "+xhr.statusText);
			},
			success:function(data){				
				//$(data).find("name")  => 파싱
				$("#result").html($(data).find("name"));
			}
		});
	});//xml click
	
	
	$("#json").click(function() {
		$.ajax({
			url:"ajax.json",
			dataType:"json",
			error:function(xhr){
				console.log("문제발생"+xhr.status+", "+xhr.statusText);
			},
			success:function(data){				
				//alert(data); //JSON: Object   /  text: text   --> 응답되는 형태에 따라 다름
				$("#result").html(data.name+"\t"+data.age);
			}
		});
	});//html click
	
});//ready
</script>
<style type="text/css">
#result {border:1px solid #333; width:800px; height:200px; margin-top:20px;}
</style>
</head>
<body>
<input type="button" value="HTML요청" id="html" class="btn btn-success"/>
<input type="button" value="text요청" id="text" class="btn btn-danger"/>
<input type="button" value="xml요청" id="xml" class="btn btn-info"/>
<input type="button" value="json요청" id="json" class="btn btn-dark"/>
<div id="result"></div>
</body>
</html>