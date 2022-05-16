<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"
    %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<% out.println(request.getAttribute("data")); %>
<%--
  c:out을 사용하면 "가 코드값으로 출력되어 자스에서 parsing이 안됨
 <c:out value="${data}" escapeXml="false"/>--%>