<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>openApi</title>
<script language="javascript">
function goPopup(){
	var pop=window.open("./popup/jusoPopup.jsp","pop","width=570,height=420,scrollbars=yes, resizable=yes")
	
}
function jusoCallBack(roadFullAddr,roadAddrPart1,addrDetail,roadAddrPart2,engAddr, jibunAddr, zipNo, admCd, rnMgtSn, bdMgtSn , detBdNmList, bdNm, bdKdcd, siNm, sggNm, emdNm, liNm, rn, udrtYn, buldMnnm, buldSlno, mtYn, lnbrMnnm, lnbrSlno, emdNo){ 
	document.form.roadFullAddr.value = roadFullAddr; 
	document.form.roadAddrPart1.value = roadAddrPart1;
	document.form.roadAddrPart2.value = roadAddrPart2; 
	documentform.addrDetail.value = addrDetail; 
	document.form.zipNo.value = zipNo; 
} </script>

</head>
<body>
<form name="form" id="form" method="post">
 <input type="button" onClick="goPopup();" value="�˾�"/>
  ���θ��ּ� ��ü(����)<input type="text" id="roadFullAddr" name="roadFullAddr" /><br>
  ���θ��ּ� <input type="text" id="roadAddrPart1" name="roadAddrPart1" /><br>
  ���Է� ���ּ�<input type="text" id="addrDetail" name="addrDetail" /><br>
  �����ּ�<input type="text" id="roadAddrPart2" name="roadAddrPart2" /><br> 
  �����ȣ<input type="text" id="zipNo" name="zipNo" /> 
</form>

</body>
</html>