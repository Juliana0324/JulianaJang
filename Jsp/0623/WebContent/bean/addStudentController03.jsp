<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <!-- Bean ��ü�� �̿��Ͽ� �Ķ���� �ڵ����� ���� -->
    
    
    <!-- jsp:useBean - class���� = new Ŭ����(); �� ������ �ǹ̸� ���� jsp�׼� �ױ�
    -Attribute���� �߰��Ѵ�
    -->    
<%-- chap01.beans.Student student=new chap01.beans.Student(); --%>
<jsp:useBean id="student" class="chap01.beans.Student" scope="request"/>
<%-- scope : https://victorydntmd.tistory.com/155 �ڼ��� �˱� --%>

<!-- ���� ���  -->
<!-- jsp:setProperty
	==> �ڹٺ� ��ü�� setter�� �̿��� ���� ä����
	- property �� MAP�� KEY�� �ش�
	- property�� input�� name �Ӽ��� �ش�
	- property�� *�� ����ϸ�
	���޹��� input�� name�Ӽ��� Bean��ü�� �ʵ���� ��ġ�ϸ� �˾Ƽ� ����
	
-->

<!-- form name�� BEAN�ʵ���� ��ġ��Ű�� ��û������ --> 
<jsp:setProperty name="student" property="*"/>


<!-- jsp�׼��ױ׵� ��ũ��Ʈ �ּ��� ��� -->
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