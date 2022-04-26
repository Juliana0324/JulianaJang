<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- 공통 CSS -->
<link rel="stylesheet" type="text/css" href="http://211.63.89.130/jsp_prj/common/css/main_20220321.css">
<style type="text/css">
#idResult{ color: #FF0000 }
</style>
<!-- jQuery CDN -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<!-- bootstrap CDN -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>

<script type="text/javascript">
var idDupFlag=false;
$(function(){
	 $("#id").keyup(function() {
		var id=$("#id").val();
		if(id.length>3){
		 $.ajax({
			url:"ckId.jsp",
			data:{"id":id},
			type:"get",
			dataType:"json",
			error:function(xhr){
				console.log("문제발생"+xhr.status+", "+xhr.statusText);
			},
			
			success:function(jsonObj){
				var output="사용불가능";
				var fontColor="#ff0000";
				idDupFlag=false;
				if(!jsonObj.flag){
					idDupFlag=true;
					fontColor="#0000ff";
					output="사용가능";
				}				
				$("#idResult").css(fontColor);
				$("#idResult").html(output);
				
			}
			}); 
		}
	});
	
	$("#btn").click(function() {
		chkNull();
	});
	
	function chkNull() {
		if(!idDupFlag){
			alert("아이디 사용불가");
			return;
		}	
		
		alert("회원가입완료")
		//$("").submit();
	}	 
	
});//ready
</script>
</head>
<body>
<!-- 입력된 id가 사용가능한지 아닌지 키가 눌릴때마다 체크하여 idResult에 사용가능 or 사용불가능  -->
<form action="">
<label>아이디</label>
<input type="text" name="id" id="id" class="inputBox"/><span id="idResult"></span><br/>
<label>비밀번호</label>
<input type="password" name="passwd" class="inputBox"/><br/>

<input type="button" name="submit" class="btn btn-success" id="btn" value="Submit"/><br/>
</form>

</body>
</html>