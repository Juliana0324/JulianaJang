<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<% 
//����ڿ��� ���޹��� ��û�� �ؼ��Ҷ� ����� charset�� ����
	request.setCharacterEncoding("EUC-KR");
// request�� ��û�� �ؼ��ϴ¤� ����� �����ص� GET��Ŀ�û�� ������ �ѱ��� ������.
//GET ����� �ּҰ�(URI)�� �Ƿ��� �����ϰ� �Ǵ�
//URI�� ���ڵ� ����� Apache/Tomcat���� ����
// Apache/Tomcat �⺻��==> UTF-8

// Apache/Tomcat�� Connector������ URIEncoding="EUC-KR" �߰�
//��ġ==>  Servers=> sever.xml    <Connector connectionTimeout="20000" port="8080" protocol="HTTP/1.1" redirectPort="8443" URIEncoding="EUC-KR"/>

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>�ѱ� �ȳ��ö� �������</title>
</head>
<body>
	TEST : ${param.test }<br>
</body>
</html>