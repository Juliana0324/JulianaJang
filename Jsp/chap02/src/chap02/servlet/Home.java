package chap02.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Home extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {		
		resp.setCharacterEncoding("EUC-KR");
		resp.setContentType("EUC-KR");
		resp.getWriter().append("web.xml로 들어온 Servlet");
	}
}
