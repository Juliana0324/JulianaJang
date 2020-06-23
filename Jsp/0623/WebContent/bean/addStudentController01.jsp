<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	//form.jsp에서 전송된 데이터를 받기
	String name= request.getParameter("name");
	String age= request.getParameter("age");
	String kor= request.getParameter("kor");
	String eng= request.getParameter("eng");
	String math= request.getParameter("math");
	
	int k = Integer.parseInt(kor);
	int e = Integer.parseInt(eng);
	int m = Integer.parseInt(math);
	
	double avg = Math.round((k + e + m)/3.0);
	
	request.setAttribute("name",name);
	request.setAttribute("age",age);
	request.setAttribute("kor",kor);
	request.setAttribute("eng",eng);
	request.setAttribute("math",math);
	request.setAttribute("avg", avg);
	
	//2. 다른 view페이지로 forward후 출력
	request.getRequestDispatcher("./view/student.jsp").forward(request,response);

%>
   <jsp:forward page="./view/student.jsp"/>
   
    