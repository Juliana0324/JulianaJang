<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<c:set var="name" value="${param.name}" scope="request"/>
<c:set var="age" value="${param.age}" scope="request"/>
<c:set var="kor" value="${param.kor}" scope="request"/>
<c:set var="eng" value="${param.eng}" scope="request"/>
<c:set var="math" value="${param.math}" scope="request"/>

<jsp:forward page="./view/student.jsp"/>