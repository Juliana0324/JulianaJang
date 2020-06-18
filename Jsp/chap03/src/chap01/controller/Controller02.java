package chap01.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Controller02 extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pageNum = req.getParameter("pageNum");
		int nextPage=404;
		
		try {
			nextPage=Integer.parseInt(pageNum);
		}catch(Exception e) {}
		
		resp.sendRedirect("/chap01/forward/view/" + nextPage + ".jsp");
	}
}
