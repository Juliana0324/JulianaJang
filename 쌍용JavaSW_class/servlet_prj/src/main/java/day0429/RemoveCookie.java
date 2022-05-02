package day0429;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RemoveCookie extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//��Ű ���� 
		//1. ���� �Ϸ��� �̸��� ��Ű ���� (��Ű�� ����Ҽ� ���� null������)
		Cookie nameCookie=new Cookie("cookieName", "");
		
		Cookie ageCookie= new Cookie("cookieAge", "");
		
		nameCookie.setMaxAge(0);
		ageCookie.setMaxAge(0);
		
		//��Ű �ɱ�
		response.addCookie(nameCookie);
		response.addCookie(ageCookie);
		
		response.sendRedirect("http://localhost/servlet_prj/read_cookie");
	}

}
