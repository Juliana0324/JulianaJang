package chap01.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RuntimeServlet")
public class RuntimeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RuntimeServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int a=3;
		int b=a/(int)(Math.random()*2);
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out= response.getWriter();
		out.println("<HTML>");
		out.println("<HEAD><TITLE>서블릿 에러예제</TITLE></HEAD>");
		out.println("<BODY>");
		out.printf("결과값: %d <BR>", b);
		out.println("</BODY>");
		out.println("</HTML>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
