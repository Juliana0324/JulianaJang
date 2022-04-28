package day0428;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class FormProcess extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		request.setCharacterEncoding("UTF-8");
		out.print("<strong>"+request.getParameter("name")+"</strong>");
		out.println("¥‘ æ»≥Á«œººø‰!");
		out.print("<a href='javascript:history.back()'>¥ŸΩ√¿‘∑¬</a>");
		
	}

}
