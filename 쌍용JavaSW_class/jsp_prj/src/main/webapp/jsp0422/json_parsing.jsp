<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    info="jQuery Parser를 이용한 JSON Parsing"
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
	$("#parsing1").click(function() {
		$.ajax({
			url: "parsing1.jsp",
			type: "post",
			dataType: "json",
			error:function(xhr){
				console.log("문제발생"+xhr.status+", "+xhr.statusText);
			},
			
			success: function (jsonObj) {
				var name="";
				var age="";
				if(jsonObj.flag){
					name=jsonObj.name;
					age=jsonObj.age;
				}
				
				$("#name").val(name);
				$("#age").val(age);
				
			}
		});
	});//click

	$("#parsing2").click(function() {
		$.ajax({
			url:"http://localhost/jsp_prj/jsp0422/parsing2.jsp",
			type:"get",
			dataType:"json",
			error:function(xhr){
				console.log("문제발생"+xhr.status+", "+xhr.statusText);
			},
			
			success: function (jsonArr) {
				var output="";
				$.each(jsonArr,function(i, jsonObj) {
					output+="<div><strong>이름</strong>: "+jsonObj.name
					+",<strong>나이</strong> :"+jsonObj.age+" </div>";

					$("#tab > tbody").append("<tr><td>"+jsonObj.name+"</td><td>"+jsonObj.age+"</td></tr>");
				}); 
				$("#output").html(output);
				
			}
			
		});
	});//click
	
	$("#parsing3").click(function() {
		$.ajax({
			url:"http://localhost/jsp_prj/jsp0422/parsing3.jsp",
			type:"get",
			dataType:"json",
			error:function(xhr){
				console.log("문제발생"+xhr.status+", "+xhr.statusText);
			},
			
			success: function (jsonObj,jsonArr) {
				var output="조회결과 없음";
/* 				
					+"<strong>조회건수</strong>: ";
 //if(resultData)
 */					
					output+="<div><strong>생산일</strong>: "+jsonObj.pubDate+"<br/>"
					+"<strong>조회건수</strong>: "+jsonObj.dataSize+"<br/>";
				
				if(!jsonObj.dateFlag){
					output+= "조회결과 없음";
				}else{
					$.each(jsonObj.resultData, function(i, jsonObj) {
						output+="<input type='text' name='num' value='"+jsonObj.num+"'/><br/>"
							+"<input type='text' name='name' value='"+jsonObj.name+"'/><br/>"
							+"<input type='text' name='fileSystemName' value='"+jsonObj.file_system_name+"'/><br/>"
							+"<input type='text' name='ip_address' value='"+jsonObj.ip_address+"'/><br/>"
							+"<input type='text' name='input_date' value='"+jsonObj.input_date+"'/></div>" ;
					
					})
				}
	
				$("#output").html(output);
				
			}			
			
		})

	
	});//click
});//ready
</script>
<style type="text/css">

#output {margin-top:20px; margin-bottom: 20px;
		width:800px; height: 200px; overflow: auto;
		border: 1px solid #333;
}
</style>
</head>
<body>
<div>
	<input type="button" value="jsonObject파싱" class="btn btn-info" id="parsing1"/>
	<input type="button" value="jsonArray파싱" class="btn btn-dark" id="parsing2"/>
	<input type="button" value="jsonObject 복합 데이터 파싱" class="btn btn-danger" id="parsing3"/>
</div>
<div id="output">
</div>
<label>이름</label><input type="text" name="name" class="inputBox" id="name"/><br>
<label>나이</label><input type="text" name="age" class="inputBox" id="age"/>
<br>
<div style="width:400px">
<table id="tab" class="table">
<thead>
<tr>
	<th style="width:250px">이름</th>
	<th style="width:150px">나이</th>
</tr>
</thead>
<tbody></tbody>
</table>
</div>

</body>
</html>