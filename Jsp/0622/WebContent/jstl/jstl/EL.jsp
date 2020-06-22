<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<% 
	//JSP���� Attribute�� �Ǿ������ �ִ� ��ü 4����
	// 1. application ��ü
	//  	-�� ������ �ϳ��̸�, ������ ������ ���� ���� �����ȴ�.
	// 2. session ��ü
	//		- �� ������(Ŭ���̾�Ʈ) �� �ϳ��̸�, ������ ���� �ɶ� ���� �����ȴ�.
	//			�α��� �����ؾ��� �� ��� 
	// 3. request ��ü
	//		- ��û���� ����� ��ü. forward�� ���� ���ޱ��� ����
	// 4. pageContext ��ü
	//		- �ϳ��� JSP�������� ����� ������ ���ϴ� ���尴ü
	
	application.setAttribute("id","app_id");
	session.setAttribute("id","session_id");
	request.setAttribute("id","req_id");
	pageContext.setAttribute("id","page_id");

%>


<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h3>EL�� ID�� ���: ${id }</h3>
	<p>
	EL�� ���� Attribute���� ����� �ÿ� �ߺ��Ǵ� key���� �ִٸ�,<br>
	���� ���� ������ ���� ������� ��� ==> page,request,session,application
	</p>
	<hr>
	<h3>EL�� literal</h3>
		<ul>
			<li> boolean type: ${true },${false }</li>
			<li> int type: ${123 },${456 }</li>
			<li> double type: ${1.234 },${45.6 }</li>
			<li> String type: ${"JAVA" },${'Python' }</li>
		</ul>
		<hr>
	<h3>EL�� ������</h3>
		<ul>
			<li>
				���������: +,-,/,*,%,mod
			</li>
			<li>
				�񱳿�����: ==,!=,&lt;,&gt;, &ge;,&le;,
					eq(equal),ne(not equal),lt(lesser than),gt(greater than),
					le(lesser or equal),ge(greater than equal)	
			</li>
			<li>
			${'a' eq 'a' },${'c' gt 'a' },${'z' lt 'a' }
			</li>
			<li>
				�� ������ : &&. ||. !,and, or, not
			</li>
			<li>
			${true or false },${true and true },${not true },${!treue }
			</li>
			<li>
				-Parameterüũ�� ����-<br>
				empty: null�̰ų� ����ִ� ���ڶ�� true
			</li>

		</ul>	
		<%
		//empty�� �ڹٷ� ǥ���ϱ� ���ŷӴ�
		String str= "";
		out.print(str ==null || str =="");
		%>	
		
		<hr>
		<h3>EL�� JSP��ü�� ����</h3>
		<p>���� ����� ������ �����ϰ� ���ϴ� ������ Attribute ����</p>
		pageScope: ${pageScope.id }<br>
		requestScope: ${requestScope.id }<br>
		sessionScope: ${sessionScope.id }<br>
		applicationScope: ${applicationScope.id }<br>
	
	<p>
		�Ķ���� ���� �����ϱ�(Ŭ���̾�Ʈ�� FORM���� ������ ������)<br>
		�� ������
	</p>
	�Ķ���� �� ���� : param.key ${param.age }<br>
	�Ķ������ ��簪 ����: paramValues ${paramValues }<br>
	
	<p>
		��Ű���� �����ϱ�
	</p>
	��Ű�� ����: ${cookie.JSESSIONID.name }=${cookie.JSESSIONID.value }
	
</body>
</html>