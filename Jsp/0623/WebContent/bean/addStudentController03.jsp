<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <!-- Bean 객체를 이용하여 파라미터 자동으로 매핑 -->
    
    
    <!-- jsp:useBean - class변수 = new 클래스(); 와 동일한 의미를 갖는 jsp액션 테그
    -Attribute에도 추가한다
    -->    
<%-- chap01.beans.Student student=new chap01.beans.Student(); --%>
<jsp:useBean id="student" class="chap01.beans.Student" scope="request"/>
<%-- scope : https://victorydntmd.tistory.com/155 자세히 알기 --%>

<!-- 쓰는 방식  -->
<!-- jsp:setProperty
	==> 자바빈 객체의 setter를 이용해 값을 채워줌
	- property 가 MAP의 KEY에 해당
	- property가 input의 name 속성에 해당
	- property에 *을 사용하면
	전달받은 input의 name속성과 Bean객체의 필드명이 일치하면 알아서 매핑
	
-->

<!-- form name과 BEAN필드명을 일치시키면 엄청편해짐 --> 
<jsp:setProperty name="student" property="*"/>


<!-- jsp액션테그도 스크립트 주석을 사용 -->
<%--  
<jsp:setProperty name="student" property="name" value="${param.name }"/>
<jsp:setProperty name="student" property="age" value="${param.age }"/>
<jsp:setProperty name="student" property="kor" value="${param.kor }"/>
<jsp:setProperty name="student" property="eng" value="${param.eng }"/>
<jsp:setProperty name="student" property="math" value="${param.math }"/>
--%>

${student}<br>
${student.name }<br>
${student.age }<br>
${student.kor }<br>
${student.eng }<br>
${student.math }<br>
${student.avg }<br>


<jsp:forward page="./view/student02.jsp"/>