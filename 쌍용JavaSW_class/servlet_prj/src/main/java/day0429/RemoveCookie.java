package day0429;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RemoveCookie extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//쿠키 삭제 
		//1. 삭제 하려는 이름의 쿠키 생성 (쿠키는 사용할수 없게 null값으로)
		Cookie nameCookie=new Cookie("cookieName", "");
		
		Cookie ageCookie= new Cookie("cookieAge", "");
		
		nameCookie.setMaxAge(0);
		ageCookie.setMaxAge(0);
		
		//쿠키 심기
		response.addCookie(nameCookie);
		response.addCookie(ageCookie);
		
		response.sendRedirect("http://localhost/servlet_prj/read_cookie");
	}

}
