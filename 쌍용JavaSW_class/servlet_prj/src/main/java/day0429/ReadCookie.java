package day0429;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@SuppressWarnings("serial")
public class ReadCookie extends HttpServlet {
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//쿠키읽기
		Cookie[] cookies=request.getCookies();
		boolean cookieFlag=false;
		
		if(cookies != null) {
			for(Cookie cookie:cookies) {
				if(!"JSESSIONID".equals(cookie.getName())) {
					cookieFlag=true;
					request.setAttribute(cookie.getName(), cookie.getValue());
				}
			}//for
		}//if	
		request.setAttribute("cookieFlag", cookieFlag);
		
		//이동
		RequestDispatcher rd= request.getRequestDispatcher("day0429/read_cookie.jsp");
		rd.forward(request, response);
	}

}
