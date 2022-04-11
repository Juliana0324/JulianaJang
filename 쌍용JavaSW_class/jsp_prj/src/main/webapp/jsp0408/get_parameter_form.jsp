<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here.</title>
<!-- 공통 CSS -->
<link rel="stylesheet" type="text/css" href="http://localhost/html_prj/common/css/main_20220321.css">
<!-- bootstrap CDN -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>

<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>

<style type="text/css">

</style>
<script type="text/javascript">
function requestJsp() {
	document.frm.submit();
//$("[name='frm']").submit();
}
function requestPostJsp() {

	if(confirm(document.postFrm.method+"으로 전송")){		
		document.postFrm.submit();
	}
//$("[name='frm']").submit();
}
</script>
</head>
<body>
<form name="frm" method="get" action="get_parameter_process.jsp">
<div>
<strong>HTML FOrm Control값 받기</strong><br/>
<label>text</label> <input type="text" name="text" class="inputBox"/><br/>
<label>password</label> <input type="password" name="password" class="inputBox"/><br/>
<label>hidden</label> <input type="hidden" name="hid" value="숨김값" class="inputBox"/><br/>
<label>date</label> <input type="date" name="date" class="inputBox"/><br/>
<!-- file 값을 설정할 수 없다. -->
<label>file</label> <input type="file" name="file" class="inputBox"/><br/>
<label>textarea</label> <textarea name="ta" class="inputBox" style="width:300px;height: 100px" ></textarea><br/>
<img src="../common/imgs/daum_logo.png" name="img"/><br/>
</div>
<div>
<strong>상태변환</strong>
<label>성별</label>
<input type="radio" name="gender" value="남자">남 
<input type="radio" name="gender" value="여자">여 
<br/>
</div>
<div>
<strong>selected 속성 사용</strong><br/>
<select name="domain">
	<option value="none">직접입력</option>
	<option value="gmail.com">지메일</option>
	<option value="daum.net">다음</option>
	<option value="naver.com">네이버</option>
</select>

<br/>
<!-- value=속성이 존재하지 않으면 on이 넘어온다 -->
<input type="checkbox" name="flag"/>삭제
<input type="button" value="전송" class="btn btn-success" onclick="requestJsp()"/><br/>
</div>
<div>
</div>
</form>
<hr/>
<form name="postFrm" method="post" action="get_parameter_process.jsp">
<div>
<strong>HTML FOrm Control값 받기</strong><br/>
<label>text</label> <input type="text" name="text" class="inputBox"/><br/>
<label>password</label> <input type="password" name="password" class="inputBox"/><br/>
<label>hidden</label> <input type="hidden" name="hid" value="숨김값" class="inputBox"/><br/>
<label>date</label> <input type="date" name="date" class="inputBox"/><br/>
<!-- file 값을 설정할 수 없다. -->
<label>file</label> <input type="file" name="file" class="inputBox"/><br/>
<label>textarea</label> <textarea name="ta" class="inputBox" style="width:300px;height: 100px" ></textarea><br/>
<img src="../common/imgs/daum_logo.png" name="img"/><br/>
</div>
<div>
<strong>상태변환</strong>
<label>성별</label>
<input type="radio" name="gender" value="남자">남 
<input type="radio" name="gender" value="여자">여 
<br/>
</div>
<div>
<strong>selected 속성 사용</strong><br/>
<select name="domain">
	<option value="none">직접입력</option>
	<option value="gmail.com">지메일</option>
	<option value="daum.net">다음</option>
	<option value="naver.com">네이버</option>
</select>

<br/>
<!-- value=속성이 존재하지 않으면 on이 넘어온다 -->
<input type="checkbox" name="flag"/>삭제
<input type="button" value="전송" class="btn btn-success" onclick="requestPostJsp()"/><br/>
</div>
<div>
</div>
</form>

</body>
</html>