<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    info="로그인폼"
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
$(function(){
	$("#id").keydown(function(evt) {
		if(evt.which == 13){
			chkNull();
		}	
	});
	
	$("#password").keydown(function(evt) {
		if(evt.which == 13){
			chkNull();
		}	
	});
	
	$("#btn").click(function() {
			chkNull();
		});
		
});//ready
function chkNull() {
	if($("#id").val() ==""){
		alert("아이디는 필수 입력!");
		$("#id").focus();
		return;
	}
	if($("#password").val() ==""){
		alert("비밀번호는 필수 입력!");
		$("#password").focus();
		return;
	}
	
//alert($("[name='cmd']").val())
//cmd는 잘 설정되어는데 submit 이 안되요 button에 name이 submit이어서  전송이 안되었스빈다.넵!
	$("#frm").submit();
	
}	 
	
</script>
</head>
<body>
<form action="login_process.do" method="post" name="frm" id="frm">
<input type="hidden" name="cmd" value="L002"/>
<!-- 입력된 id가 사용가능한지 아닌지 키가 눌릴때마다 체크하여 idResult에 사용가능 or 사용불가능  -->
<label>아이디</label>
<input type="text" name="id" id="id" class="inputBox"/><br/>
<label>비밀번호</label>
<input type="password" name="passwd" id="password" class="inputBox"/><br/>

<input type="button"  class="btn btn-success" id="btn" value="Submit"/><br/>

</form>
</body>
</html>